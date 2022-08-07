package mao.service_acl.service.impl;

import mao.service_acl.entity.User;
import mao.service_acl.service.IPermissionService;
import mao.service_acl.service.IUserService;
import mao.spring_security.entity.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.service_acl.service.impl
 * Class(类名): UserDetailsServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/6
 * Time(创建时间)： 21:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        //根据用户名查询数据
        User user = userService.selectByUsername(username);
        //判断
        if (user == null)
        {
            throw new UsernameNotFoundException("用户不存在");
        }
        mao.spring_security.entity.User curUser = new mao.spring_security.entity.User();
        BeanUtils.copyProperties(user, curUser);

        //根据用户查询用户权限列表
        List<String> permissionValueList = permissionService.selectPermissionValueByUserId(user.getId());
        SecurityUser securityUser = new SecurityUser();
        securityUser.setCurrentUserInfo(curUser);
        securityUser.setPermissionValueList(permissionValueList);
        return securityUser;
    }
}
