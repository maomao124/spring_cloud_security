package utils.exceptionhandler;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): utils.exceptionhandler
 * Class(类名): MyException
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 22:28
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class MyException extends RuntimeException
{
    //状态码
    private Integer code;
    //异常信息
    private String msg;

    /**
     * Instantiates a new My exception.
     */
    public MyException()
    {

    }

    /**
     * Instantiates a new My exception.
     *
     * @param code the code
     * @param msg  the msg
     */
    public MyException(Integer code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode()
    {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(Integer code)
    {
        this.code = code;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg()
    {
        return msg;
    }

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
