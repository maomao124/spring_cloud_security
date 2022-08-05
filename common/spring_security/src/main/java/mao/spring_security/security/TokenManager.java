package mao.spring_security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.spring_security.security
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
    //token有效时长，单位为毫秒
    private final long tokenEffectiveTime = 24 * 60 * 60 * 1000;
    //编码秘钥
    private final String tokenSignKey = "123456";

    /**
     * 使用jwt根据用户名生成token
     *
     * @param username 用户名
     * @return token
     */
    public String createToken(String username)
    {
        String token = Jwts.builder().setSubject(username)
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenEffectiveTime))
                //设置JWA算法和编码秘钥
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                //设置压缩算法的编解码器
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    /**
     * 根据token字符串得到用户信息
     *
     * @param token token
     * @return userinfo
     */
    public String getUserInfoFromToken(String token)
    {
        String userInfo = Jwts.parser()
                .setSigningKey(tokenSignKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userInfo;
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
