package mao.spring_security.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.spring_security.entity
 * Class(类名): SecurityUser
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 23:03
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class SecurityUser implements UserDetails
{

    //当前登录用户
    private transient User currentUserInfo;

    //当前权限列表
    private List<String> permissionValueList;

    /**
     * Instantiates a new Security user.
     */
    public SecurityUser()
    {

    }

    /**
     * Instantiates a new Security user.
     *
     * @param user the user
     */
    public SecurityUser(User user)
    {
        if (user != null)
        {
            this.currentUserInfo = user;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String permissionValue : permissionValueList)
        {
            //判断是否为空
            if (StringUtils.isEmpty(permissionValue))
            {
                continue;
            }
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permissionValue);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return currentUserInfo.getPassword();
    }

    @Override
    public String getUsername()
    {
        return currentUserInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    /**
     * Gets current user info.
     *
     * @return the current user info
     */
    public User getCurrentUserInfo()
    {
        return currentUserInfo;
    }

    /**
     * Sets current user info.
     *
     * @param currentUserInfo the current user info
     */
    public void setCurrentUserInfo(User currentUserInfo)
    {
        this.currentUserInfo = currentUserInfo;
    }

    /**
     * Gets permission value list.
     *
     * @return the permission value list
     */
    public List<String> getPermissionValueList()
    {
        return permissionValueList;
    }

    /**
     * Sets permission value list.
     *
     * @param permissionValueList the permission value list
     */
    public void setPermissionValueList(List<String> permissionValueList)
    {
        this.permissionValueList = permissionValueList;
    }
}
