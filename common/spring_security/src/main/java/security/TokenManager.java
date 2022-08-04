package security;

import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): security
 * Class(类名): TokenManager
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 23:27
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component
public class TokenManager
{
    //token有效时长
    private long tokenEffectiveTime = 24 * 60 * 60 * 1000;
    //编码秘钥
    private String tokenSignKey = "123456";

    /**
     * 使用jwt根据用户名生成token
     *
     * @param username 用户名
     * @return token
     */
    public String createToken(String username)
    {

    }

    /**
     * 根据token字符串得到用户信息
     * @param token token
     * @return userinfo
     */
    public String getUserInfoFromToken(String token)
    {

    }

    /**
     * 删除token
     *
     * @param token token
     */
    public void removeToken(String token)
    {

    }


}
