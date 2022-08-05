package filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.SecurityUser;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import security.TokenManager;
import utils.ResponseUtil;
import utils.Result;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): filter
 * Class(类名): TokenLoginFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/5
 * Time(创建时间)： 20:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter
{
    private final TokenManager tokenManager;
    private final StringRedisTemplate stringRedisTemplate;
    private final AuthenticationManager authenticationManager;


    public TokenLoginFilter(TokenManager tokenManager, StringRedisTemplate stringRedisTemplate, AuthenticationManager authenticationManager)
    {
        this.tokenManager = tokenManager;
        this.stringRedisTemplate = stringRedisTemplate;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException
    {
        log.debug("开始获取表单提交的用户名和密码");
        //获取表单提交的用户名和密码
        try
        {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException
    {
        log.debug("认证成功，调用TokenLoginFilter的successfulAuthentication方法");
        //认证成功调用该方法
        //获取用户信息
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        //根据用户名生成token
        String token = tokenManager.createToken(user.getCurrentUserInfo().getUsername());
        //把用户名称和用户权限列表放到redis
        String json = JSON.toJSONString(user.getPermissionValueList());
        stringRedisTemplate.opsForValue().set("security:user:" + user.getCurrentUserInfo().getUsername(), json);
        log.debug("将权限列表放入redis：" + json);
        //返回token
        log.debug("返回token：\n" + token + "\n");
        ResponseUtil.out(response, Result.ok().data("token", token));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException
    {
        log.debug("认证失败");
        //返回失败
        ResponseUtil.out(response, Result.error().message("认证失败"));
    }
}
