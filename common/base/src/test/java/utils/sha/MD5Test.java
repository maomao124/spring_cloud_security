package utils.sha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): utils.sha
 * Class(测试类名): MD5Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 22:55
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class MD5Test
{

    @org.junit.jupiter.api.Test
    void getMD5()
    {
        String md5 = MD5.getMD5("123");
        System.out.println(md5);
    }

    @Test
    void getMD5toUpperCase()
    {
        String md5toUpperCase = MD5.getMD5toUpperCase("123");
        System.out.println(md5toUpperCase);
    }
}