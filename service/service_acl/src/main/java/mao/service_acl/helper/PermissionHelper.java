package mao.service_acl.helper;

import mao.service_acl.entity.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.service_acl.helper
 * Class(类名): PermissionHelper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/7
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class PermissionHelper
{
    /**
     * 使用递归方法建菜单
     *
     * @param treeNodes List<Permission> treeNodes
     * @return List<Permission>
     */
    public static List<Permission> build(List<Permission> treeNodes)
    {
        List<Permission> trees = new ArrayList<>();
        for (Permission treeNode : treeNodes)
        {
            if ("0".equals(treeNode.getPid()))
            {
                treeNode.setLevel(1);
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes List<Permission> treeNodes
     * @return Permission
     */
    public static Permission findChildren(Permission treeNode, List<Permission> treeNodes)
    {
        treeNode.setChildren(new ArrayList<>());

        for (Permission it : treeNodes)
        {
            if (treeNode.getId().equals(it.getPid()))
            {
                int level = treeNode.getLevel() + 1;
                it.setLevel(level);
                if (treeNode.getChildren() == null)
                {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
