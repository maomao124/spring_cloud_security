package utils.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): utils.exceptionhandler
 * Class(类名): GlobalExceptionHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 22:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler
{
    /**
     * 指定出现什么异常执行这个方法
     *
     * @param e the e
     * @return the result
     */

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e)
    {
        e.printStackTrace();
        return Result.error().message("执行了全局异常处理..");
    }

    /**
     * 特定异常
     *
     * @param e the e
     * @return the result
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e)
    {
        e.printStackTrace();
        return Result.error().message("执行了ArithmeticException异常处理..");
    }

    /**
     * 自定义异常
     *
     * @param e the e
     * @return the result
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result error(MyException e)
    {
        log.error(e.getMessage());
        e.printStackTrace();

        return Result.error().code(e.getCode()).message(e.getMsg());
    }
}
