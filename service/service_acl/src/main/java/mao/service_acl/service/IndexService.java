package mao.service_acl.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): mao.service_acl.service
 * Interface(接口名): IndexService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/6
 * Time(创建时间)： 21:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface IndexService
{
    /**
     * 根据用户名获取用户登录信息
     *
     * @param username 用户名获
     * @return Map<String, Object>
     */
    Map<String, Object> getUserInfo(String username);

    /**
     * 根据用户名获取动态菜单
     *
     * @param username 用户名
     * @return List<JSONObject>
     */
    List<JSONObject> getMenu(String username);
}
