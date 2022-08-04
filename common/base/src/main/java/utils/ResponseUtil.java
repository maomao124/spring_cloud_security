package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): utils
 * Class(类名): ResponseUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 22:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class ResponseUtil
{
    /**
     * Out.
     *
     * @param response the response
     * @param result   the result
     */
    public static void out(HttpServletResponse response, Result result)
    {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try
        {
            mapper.writeValue(response.getWriter(), result);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
