package mao.service_acl.service.impl;

import mao.service_acl.entity.User;
import mao.service_acl.mapper.UserMapper;
import mao.service_acl.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService
{

    @Override
    public User selectByUsername(String username)
    {
        return null;
    }
}
