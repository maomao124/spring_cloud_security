package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): utils
 * Class(类名): Result
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 22:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Result
{
    //是否成功
    private Boolean success;

    //响应状态码
    private Integer code;

    //响应的信息
    private String message;

    //数据
    private Map<String, Object> data = new HashMap<>();

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Map<String, Object> getData()
    {
        return data;
    }

    public void setData(Map<String, Object> data)
    {
        this.data = data;
    }


    /**
     * 把构造方法私有
     */
    private Result()
    {
    }


    /**
     * 成功的静态方法
     *
     * @return Result对象
     */
    public static Result ok()
    {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }


    /**
     * 失败的静态方法
     * @return Result对象
     */
    public static Result error()
    {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(201);
        result.setMessage("失败");
        return result;
    }

    public Result success(Boolean success)
    {
        this.setSuccess(success);
        return this;
    }

    public Result message(String message)
    {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code)
    {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value)
    {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map)
    {
        this.setData(map);
        return this;
    }
}
