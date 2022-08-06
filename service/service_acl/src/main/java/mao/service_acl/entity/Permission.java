package mao.service_acl.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author mao
 * @since 2022 -08-05
 */


@TableName("acl_permission")
@ApiModel(value = "Permission对象", description = "权限")
public class Permission implements Serializable
{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    private String id;

    @ApiModelProperty("所属上级")
    private String pid;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("类型(1:菜单,2:按钮)")
    private Integer type;

    @ApiModelProperty("权限值")
    private String permissionValue;

    @ApiModelProperty("访问路径")
    private String path;

    @ApiModelProperty("组件路径")
    private String component;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("状态(0:禁止,1:正常)")
    private Integer status;

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
     * Gets pid.
     *
     * @return the pid
     */
    public String getPid()
    {
        return pid;
    }

    /**
     * Sets pid.
     *
     * @param pid the pid
     */
    public void setPid(String pid)
    {
        this.pid = pid;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Integer getType()
    {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Integer type)
    {
        this.type = type;
    }

    /**
     * Gets permission value.
     *
     * @return the permission value
     */
    public String getPermissionValue()
    {
        return permissionValue;
    }

    /**
     * Sets permission value.
     *
     * @param permissionValue the permission value
     */
    public void setPermissionValue(String permissionValue)
    {
        this.permissionValue = permissionValue;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * Gets component.
     *
     * @return the component
     */
    public String getComponent()
    {
        return component;
    }

    /**
     * Sets component.
     *
     * @param component the component
     */
    public void setComponent(String component)
    {
        this.component = component;
    }

    /**
     * Gets icon.
     *
     * @return the icon
     */
    public String getIcon()
    {
        return icon;
    }

    /**
     * Sets icon.
     *
     * @param icon the icon
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Integer getStatus()
    {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Integer status)
    {
        this.status = status;
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

        Permission that = (Permission) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
        {
            return false;
        }
        if (getPid() != null ? !getPid().equals(that.getPid()) : that.getPid() != null)
        {
            return false;
        }
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
        {
            return false;
        }
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null)
        {
            return false;
        }
        if (getPermissionValue() != null ? !getPermissionValue().equals(that.getPermissionValue()) : that.getPermissionValue() != null)
        {
            return false;
        }
        if (getPath() != null ? !getPath().equals(that.getPath()) : that.getPath() != null)
        {
            return false;
        }
        if (getComponent() != null ? !getComponent().equals(that.getComponent()) : that.getComponent() != null)
        {
            return false;
        }
        if (getIcon() != null ? !getIcon().equals(that.getIcon()) : that.getIcon() != null)
        {
            return false;
        }
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null)
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
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getPermissionValue() != null ? getPermissionValue().hashCode() : 0);
        result = 31 * result + (getPath() != null ? getPath().hashCode() : 0);
        result = 31 * result + (getComponent() != null ? getComponent().hashCode() : 0);
        result = 31 * result + (getIcon() != null ? getIcon().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
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
        stringbuilder.append("pid：").append(pid).append('\n');
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("type：").append(type).append('\n');
        stringbuilder.append("permissionValue：").append(permissionValue).append('\n');
        stringbuilder.append("path：").append(path).append('\n');
        stringbuilder.append("component：").append(component).append('\n');
        stringbuilder.append("icon：").append(icon).append('\n');
        stringbuilder.append("status：").append(status).append('\n');
        stringbuilder.append("isDeleted：").append(isDeleted).append('\n');
        stringbuilder.append("gmtCreate：").append(gmtCreate).append('\n');
        stringbuilder.append("gmtModified：").append(gmtModified).append('\n');
        return stringbuilder.toString();
    }
}
