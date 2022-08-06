package mao.service_acl.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author mao
 * @since 2022 -08-05
 */


@TableName("acl_user")
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("会员id")
    private String id;

    @ApiModelProperty("微信openid")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("用户头像")
    private String salt;

    @ApiModelProperty("用户签名")
    private String token;

    @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty("更新时间")
    private LocalDateTime gmtModified;


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Gets nick name.
     *
     * @return the nick name
     */
    public String getNickName()
    {
        return nickName;
    }

    /**
     * Sets nick name.
     *
     * @param nickName the nick name
     */
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    /**
     * Gets salt.
     *
     * @return the salt
     */
    public String getSalt()
    {
        return salt;
    }

    /**
     * Sets salt.
     *
     * @param salt the salt
     */
    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token)
    {
        this.token = token;
    }

    /**
     * Gets is deleted.
     *
     * @return the is deleted
     */
    public Integer getIsDeleted()
    {
        return isDeleted;
    }

    /**
     * Sets is deleted.
     *
     * @param isDeleted the is deleted
     */
    public void setIsDeleted(Integer isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    /**
     * Gets gmt create.
     *
     * @return the gmt create
     */
    public LocalDateTime getGmtCreate()
    {
        return gmtCreate;
    }

    /**
     * Sets gmt create.
     *
     * @param gmtCreate the gmt create
     */
    public void setGmtCreate(LocalDateTime gmtCreate)
    {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Gets gmt modified.
     *
     * @return the gmt modified
     */
    public LocalDateTime getGmtModified()
    {
        return gmtModified;
    }

    /**
     * Sets gmt modified.
     *
     * @param gmtModified the gmt modified
     */
    public void setGmtModified(LocalDateTime gmtModified)
    {
        this.gmtModified = gmtModified;
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

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
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
        if (getSalt() != null ? !getSalt().equals(user.getSalt()) : user.getSalt() != null)
        {
            return false;
        }
        if (getToken() != null ? !getToken().equals(user.getToken()) : user.getToken() != null)
        {
            return false;
        }
        if (getIsDeleted() != null ? !getIsDeleted().equals(user.getIsDeleted()) : user.getIsDeleted() != null)
        {
            return false;
        }
        if (getGmtCreate() != null ? !getGmtCreate().equals(user.getGmtCreate()) : user.getGmtCreate() != null)
        {
            return false;
        }
        return getGmtModified() != null ? getGmtModified().equals(user.getGmtModified()) : user.getGmtModified() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getNickName() != null ? getNickName().hashCode() : 0);
        result = 31 * result + (getSalt() != null ? getSalt().hashCode() : 0);
        result = 31 * result + (getToken() != null ? getToken().hashCode() : 0);
        result = 31 * result + (getIsDeleted() != null ? getIsDeleted().hashCode() : 0);
        result = 31 * result + (getGmtCreate() != null ? getGmtCreate().hashCode() : 0);
        result = 31 * result + (getGmtModified() != null ? getGmtModified().hashCode() : 0);
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("id：").append(id).append('\n');
        stringbuilder.append("username：").append(username).append('\n');
        stringbuilder.append("password：").append(password).append('\n');
        stringbuilder.append("nickName：").append(nickName).append('\n');
        stringbuilder.append("salt：").append(salt).append('\n');
        stringbuilder.append("token：").append(token).append('\n');
        stringbuilder.append("isDeleted：").append(isDeleted).append('\n');
        stringbuilder.append("gmtCreate：").append(gmtCreate).append('\n');
        stringbuilder.append("gmtModified：").append(gmtModified).append('\n');
        return stringbuilder.toString();
    }
}
