package mao.service_acl.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色权限
 * </p>
 *
 * @author mao
 * @since 2022 -08-05
 */


@TableName("acl_role_permission")
@ApiModel(value = "RolePermission对象", description = "角色权限")
public class RolePermission implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;

    private String roleId;

    private String permissionId;

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
     * Gets role id.
     *
     * @return the role id
     */
    public String getRoleId()
    {
        return roleId;
    }

    /**
     * Sets role id.
     *
     * @param roleId the role id
     */
    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    /**
     * Gets permission id.
     *
     * @return the permission id
     */
    public String getPermissionId()
    {
        return permissionId;
    }

    /**
     * Sets permission id.
     *
     * @param permissionId the permission id
     */
    public void setPermissionId(String permissionId)
    {
        this.permissionId = permissionId;
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

        RolePermission that = (RolePermission) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
        {
            return false;
        }
        if (getRoleId() != null ? !getRoleId().equals(that.getRoleId()) : that.getRoleId() != null)
        {
            return false;
        }
        if (getPermissionId() != null ? !getPermissionId().equals(that.getPermissionId()) : that.getPermissionId() != null)
        {
            return false;
        }
        if (getIsDeleted() != null ? !getIsDeleted().equals(that.getIsDeleted()) : that.getIsDeleted() != null)
        {
            return false;
        }
        if (getGmtCreate() != null ? !getGmtCreate().equals(that.getGmtCreate()) : that.getGmtCreate() != null)
        {
            return false;
        }
        return getGmtModified() != null ? getGmtModified().equals(that.getGmtModified()) : that.getGmtModified() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRoleId() != null ? getRoleId().hashCode() : 0);
        result = 31 * result + (getPermissionId() != null ? getPermissionId().hashCode() : 0);
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
        stringbuilder.append("roleId：").append(roleId).append('\n');
        stringbuilder.append("permissionId：").append(permissionId).append('\n');
        stringbuilder.append("isDeleted：").append(isDeleted).append('\n');
        stringbuilder.append("gmtCreate：").append(gmtCreate).append('\n');
        stringbuilder.append("gmtModified：").append(gmtModified).append('\n');
        return stringbuilder.toString();
    }
}
