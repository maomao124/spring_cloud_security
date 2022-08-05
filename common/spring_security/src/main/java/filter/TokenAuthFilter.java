package filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import security.TokenManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): filter
 * Class(类名): TokenAuthFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/5
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class TokenAuthFilter extends BasicAuthenticationFilter
{
    private final TokenManager tokenManager;
    private final StringRedisTemplate stringRedisTemplate;


    public TokenAuthFilter(AuthenticationManager authenticationManager, TokenManager tokenManager, StringRedisTemplate stringRedisTemplate)
    {
        super(authenticationManager);
        this.tokenManager = tokenManager;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        log.debug("开始执行TokenAuthFilter过滤器的doFilterInternal方法");
        //获取当前认证成功用户权限信息
        UsernamePasswordAuthenticationToken authentication = this.getAuthentication(request);
        //判断如果有权限信息，放到权限上下文中
        if (authentication != null)
        {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    /**
     * 从request里获取用户的信息
     *
     * @param request HttpServletRequest
     * @return UsernamePasswordAuthenticationToken
     */
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request)
    {
        log.debug("获取token");
        //从请求头里获取token
        String token = request.getHeader("token");
        if (token != null)
        {
            //从请求头里获取用户名
            String userInfoFromToken = tokenManager.getUserInfoFromToken(token);
            //从redis里获取权限列表
            String json = stringRedisTemplate.opsForValue().get("security:user:" + userInfoFromToken);
            if (json == null)
            {
                return null;
            }
            List<String> permissionValueList = JSON.parseArray(json, String.class);
            if (permissionValueList == null)
            {
                permissionValueList = new ArrayList<>();
            }
            log.debug("用户为" + userInfoFromToken + "权限列表为：" + permissionValueList);
            Collection<GrantedAuthority> authority = new ArrayList<>();
            for (String permissionValue : permissionValueList)
            {
                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(permissionValue);
                authority.add(auth);
            }
            return new UsernamePasswordAuthenticationToken(userInfoFromToken, token, authority);
        }
        return null;
    }
}
