package mao.service_acl.mapper;

import mao.service_acl.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author mao
 * @since 2022 -08-05
 */

public interface PermissionMapper extends BaseMapper<Permission>
{
    /**
     * 根据用户的id查询用户的所有权限值
     *
     * @param id the id
     * @return the list
     */
    List<String> selectPermissionValueByUserId(String id);

    /**
     * Select all permission value list.
     *
     * @return the list
     */
    List<String> selectAllPermissionValue();

    /**
     * 根据用户的id查询用户的所有权限
     *
     * @param userId the user id
     * @return the list
     */
    List<Permission> selectPermissionByUserId(String userId);
}
