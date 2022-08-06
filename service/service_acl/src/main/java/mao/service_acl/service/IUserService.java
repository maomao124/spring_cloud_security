package mao.service_acl.service;

import mao.service_acl.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */
public interface IUserService extends IService<User>
{
    // 从数据库中取出用户信息
    User selectByUsername(String username);
}
