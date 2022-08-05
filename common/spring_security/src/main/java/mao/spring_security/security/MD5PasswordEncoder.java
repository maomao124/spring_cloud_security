package mao.spring_security.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import utils.sha.MD5;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.spring_security.security
 * Class(类名): MD5PasswordEncoder
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 23:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component
public class MD5PasswordEncoder implements PasswordEncoder
{
    @Override
    public String encode(CharSequence charSequence)
    {
        return MD5.getMD5(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s)
    {
        return s.equals(MD5.getMD5(charSequence.toString()));
    }
}
