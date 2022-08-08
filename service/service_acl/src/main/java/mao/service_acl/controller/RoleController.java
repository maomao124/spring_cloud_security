package mao.service_acl.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mao.service_acl.entity.Role;
import mao.service_acl.service.IRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import utils.Result;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */
@RestController
@RequestMapping("/admin/acl/role")
public class RoleController
{
    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "获取角色分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            Role role)
    {
        Page<Role> pageParam = new Page<>(page, limit);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(role.getRoleName()))
        {
            wrapper.like("role_name", role.getRoleName());
        }
        roleService.page(pageParam, wrapper);
        return Result.ok().data("items", pageParam.getRecords()).data("total", pageParam.getTotal());
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public Result save(@RequestBody Role role)
    {
        roleService.save(role);
        return Result.ok();
    }
}

