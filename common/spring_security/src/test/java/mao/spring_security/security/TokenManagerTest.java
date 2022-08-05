package mao.spring_security.security;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.spring_security.security
 * Class(测试类名): TokenManagerTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/5
 * Time(创建时间)： 19:47
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class TokenManagerTest
{

    @org.junit.jupiter.api.Test
    void createToken()
    {
        TokenManager tokenManager = new TokenManager();
        String token = tokenManager.createToken("张三");
        System.out.println(token);
    }

    @org.junit.jupiter.api.Test
    void getUserInfoFromToken()
    {
        TokenManager tokenManager=new TokenManager();
        String userInfoFromToken = tokenManager.getUserInfoFromToken("eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAA" +
                "_6tWKi5NUrJSerpnwZMdnUo6SqkVBUpWhmamluYWZuZGRrUAvJX50SEAAAA.XbLbikg0b3_OmESYia3yzwms_Ek8z" +
                "-52M69235rl11CigDoYo4rzrHQBfApFzfWCo329CB8tnkNQ0TbWbS0d5w");
        System.out.println(userInfoFromToken);
    }
}