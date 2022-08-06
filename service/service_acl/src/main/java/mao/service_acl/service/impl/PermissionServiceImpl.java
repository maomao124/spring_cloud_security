package mao.service_acl.service.impl;

import com.alibaba.fastjson.JSONObject;
import mao.service_acl.entity.Permission;
import mao.service_acl.mapper.PermissionMapper;
import mao.service_acl.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService
{

    @Override
    public List<Permission> queryAllMenu()
    {
        return null;
    }

    @Override
    public List<Permission> selectAllMenu(String roleId)
    {
        return null;
    }

    @Override
    public void saveRolePermissionRealtionShip(String roleId, String[] permissionId)
    {

    }

    @Override
    public void removeChildById(String id)
    {

    }

    @Override
    public List<String> selectPermissionValueByUserId(String id)
    {
        return null;
    }

    @Override
    public List<JSONObject> selectPermissionByUserId(String id)
    {
        return null;
    }

    @Override
    public List<Permission> queryAllMenuGuli()
    {
        return null;
    }

    @Override
    public void removeChildByIdGuli(String id)
    {

    }

    @Override
    public void saveRolePermissionRealtionShipGuli(String roleId, String[] permissionId)
    {

    }
}
