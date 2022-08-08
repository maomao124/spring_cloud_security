package mao.service_acl.controller;


import io.swagger.annotations.ApiOperation;
import mao.service_acl.entity.Permission;
import mao.service_acl.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import utils.Result;

import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */

@RestController
@RequestMapping("/admin/acl/permission")
public class PermissionController
{
    @Autowired
    private IPermissionService permissionService;

    //获取全部菜单
    @ApiOperation(value = "查询所有菜单")
    @GetMapping
    public Result indexAllPermission()
    {
        List<Permission> list = permissionService.queryAllMenu();
        return Result.ok().data("children", list);
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public Result doAssign(String roleId, String[] permissionId)
    {
        permissionService.saveRolePermissionRealtionShipGuli(roleId, permissionId);
        return Result.ok();
    }

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("toAssign/{roleId}")
    public Result toAssign(@PathVariable String roleId)
    {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return Result.ok().data("children", list);
    }
}

