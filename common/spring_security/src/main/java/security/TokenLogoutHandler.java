package security;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import utils.ResponseUtil;
import utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): security
 * Class(类名): TokenLogoutHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/5
 * Time(创建时间)： 19:57
 * Version(版本): 1.0
 * Description(描述)： 退出处理器
 */

public class TokenLogoutHandler implements LogoutHandler
{
    private final TokenManager tokenManager;
    private final StringRedisTemplate stringRedisTemplate;


    public TokenLogoutHandler(TokenManager tokenManager, StringRedisTemplate stringRedisTemplate)
    {
        this.tokenManager = tokenManager;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        String token = request.getHeader("token");
        if (token != null)
        {
            tokenManager.removeToken(token);
            String userInfoFromToken = tokenManager.getUserInfoFromToken(token);
            stringRedisTemplate.delete("security:" + userInfoFromToken);
        }
        ResponseUtil.out(response, Result.ok().message("退出成功"));
    }
}
