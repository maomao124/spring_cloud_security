package security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import utils.ResponseUtil;
import utils.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): security
 * Class(类名): UnAuthEntryPoint
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 23:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UnAuthEntryPoint implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException, ServletException
    {
        ResponseUtil.out(httpServletResponse, Result.error().message(e.getMessage()));
    }
}
