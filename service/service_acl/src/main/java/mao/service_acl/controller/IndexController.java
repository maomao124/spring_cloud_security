package mao.service_acl.controller;

import com.alibaba.fastjson.JSONObject;
import mao.service_acl.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.Result;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.service_acl.controller
 * Class(类名): IndexController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/7
 * Time(创建时间)： 21:23
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@RequestMapping("/admin/acl/index")
public class IndexController
{
    @Autowired
    private IndexService indexService;

    /**
     * 根据token获取用户信息
     */
    @GetMapping("info")
    public Result info()
    {
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return Result.ok().data(userInfo);
    }

    /**
     * 获取菜单
     *
     * @return Result
     */
    @GetMapping("menu")
    public Result getMenu()
    {
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList = indexService.getMenu(username);
        return Result.ok().data("permissionList", permissionList);
    }

    @PostMapping("logout")
    public Result logout()
    {
        return Result.ok();
    }
}
