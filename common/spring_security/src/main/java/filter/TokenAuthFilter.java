package filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

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

public class TokenAuthFilter extends BasicAuthenticationFilter
{

    public TokenAuthFilter(AuthenticationManager authenticationManager)
    {
        super(authenticationManager);
    }
}
