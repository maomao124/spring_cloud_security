package mao.service_acl.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author mao
 * @since 2022 -08-05
 */


@TableName("acl_role")
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable
{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
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
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName()
    {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    /**
     * Gets role code.
     *
     * @return the role code
     */
    public String getRoleCode()
    {
        return roleCode;
    }

    /**
     * Sets role code.
     *
     * @param roleCode the role code
     */
    public void setRoleCode(String roleCode)
    {
        this.roleCode = roleCode;
    }

    /**
     * Gets remark.
     *
     * @return the remark
     */
    public String getRemark()
    {
        return remark;
    }

    /**
     * Sets remark.
     *
     * @param remark the remark
     */
    public void setRemark(String remark)
    {
        this.remark = remark;
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

        Role role = (Role) o;

        if (getId() != null ? !getId().equals(role.getId()) : role.getId() != null)
        {
            return false;
        }
        if (getRoleName() != null ? !getRoleName().equals(role.getRoleName()) : role.getRoleName() != null)
        {
            return false;
        }
        if (getRoleCode() != null ? !getRoleCode().equals(role.getRoleCode()) : role.getRoleCode() != null)
        {
            return false;
        }
        if (getRemark() != null ? !getRemark().equals(role.getRemark()) : role.getRemark() != null)
        {
            return false;
        }
        if (getIsDeleted() != null ? !getIsDeleted().equals(role.getIsDeleted()) : role.getIsDeleted() != null)
        {
            return false;
        }
        if (getGmtCreate() != null ? !getGmtCreate().equals(role.getGmtCreate()) : role.getGmtCreate() != null)
        {
            return false;
        }
        return getGmtModified() != null ? getGmtModified().equals(role.getGmtModified()) : role.getGmtModified() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRoleName() != null ? getRoleName().hashCode() : 0);
        result = 31 * result + (getRoleCode() != null ? getRoleCode().hashCode() : 0);
        result = 31 * result + (getRemark() != null ? getRemark().hashCode() : 0);
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
        stringbuilder.append("roleName：").append(roleName).append('\n');
        stringbuilder.append("roleCode：").append(roleCode).append('\n');
        stringbuilder.append("remark：").append(remark).append('\n');
        stringbuilder.append("isDeleted：").append(isDeleted).append('\n');
        stringbuilder.append("gmtCreate：").append(gmtCreate).append('\n');
        stringbuilder.append("gmtModified：").append(gmtModified).append('\n');
        return stringbuilder.toString();
    }
}
