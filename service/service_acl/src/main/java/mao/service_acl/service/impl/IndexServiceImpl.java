package mao.service_acl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mao.service_acl.entity.Role;
import mao.service_acl.entity.User;
import mao.service_acl.service.IPermissionService;
import mao.service_acl.service.IRoleService;
import mao.service_acl.service.IUserService;
import mao.service_acl.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import utils.exceptionhandler.MyException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.service_acl.service.impl
 * Class(类名): IndexServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/6
 * Time(创建时间)： 21:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Service
public class IndexServiceImpl implements IndexService
{

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据用户名获取用户登录信息
     *
     * @param username 用户名获
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> getUserInfo(String username)
    {
        Map<String, Object> result = new HashMap<>();
        User user = userService.selectByUsername(username);
        if (null == user)
        {
            //throw new MyException(ResultCodeEnum.FETCH_USERINFO_ERROR);
        }

        //根据用户id获取角色
        List<Role> roleList = roleService.selectRoleByUserId(user.getId());
        List<String> roleNameList = roleList.stream().map(Role::getRoleName).collect(Collectors.toList());
        if (roleNameList.size() == 0)
        {
            //前端框架必须返回一个角色，否则报错，如果没有角色，返回一个空角色
            roleNameList.add("");
        }

        //根据用户id获取操作权限值
        List<String> permissionValueList = permissionService.selectPermissionValueByUserId(user.getId());

        //把用户名称和用户权限列表放到redis
        String json = JSON.toJSONString(permissionValueList);
        stringRedisTemplate.opsForValue().set("mao.spring_security.security:user:" + username, json);

        result.put("name", user.getUsername());
        result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        result.put("roles", roleNameList);
        result.put("permissionValueList", permissionValueList);
        return result;
    }

    /**
     * 根据用户名获取动态菜单
     *
     * @param username 用户名
     * @return List<JSONObject>
     */
    @Override
    public List<JSONObject> getMenu(String username)
    {
        User user = userService.selectByUsername(username);

        //根据用户id获取用户菜单权限
        List<JSONObject> permissionList = permissionService.selectPermissionByUserId(user.getId());
        return permissionList;
    }
}
