package mao.spring_security.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.spring_security.entity
 * Class(类名): User
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 23:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@ApiModel(description = "用户实体类")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String salt;

    @ApiModelProperty(value = "用户签名")
    private String token;

    public User()
    {
    }

    public User(String username, String password, String nickName, String salt, String token)
    {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.salt = salt;
        this.token = token;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        User user = (User) o;

        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
        {
            return false;
        }
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
        {
            return false;
        }
        if (getNickName() != null ? !getNickName().equals(user.getNickName()) : user.getNickName() != null)
        {
            return false;
        }
        if (getSalt() != null ? !getSalt().equals(user.getSalt()) : user.getSalt() != null) return false;
        return getToken() != null ? getToken().equals(user.getToken()) : user.getToken() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getNickName() != null ? getNickName().hashCode() : 0);
        result = 31 * result + (getSalt() != null ? getSalt().hashCode() : 0);
        result = 31 * result + (getToken() != null ? getToken().hashCode() : 0);
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("username：").append(username).append('\n');
        stringbuilder.append("password：").append(password).append('\n');
        stringbuilder.append("nickName：").append(nickName).append('\n');
        stringbuilder.append("salt：").append(salt).append('\n');
        stringbuilder.append("token：").append(token).append('\n');
        return stringbuilder.toString();
    }
}
