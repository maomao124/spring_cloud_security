package filter;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import security.TokenManager;

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

public class TokenLoginFilter  extends UsernamePasswordAuthenticationFilter
{
    private TokenManager tokenManager;
    private StringRedisTemplate stringRedisTemplate;
    private AuthenticationManager authenticationManager;


    public TokenLoginFilter(TokenManager tokenManager, StringRedisTemplate stringRedisTemplate, AuthenticationManager authenticationManager)
    {
        this.tokenManager = tokenManager;
        this.stringRedisTemplate = stringRedisTemplate;
        this.authenticationManager = authenticationManager;
    }


}
