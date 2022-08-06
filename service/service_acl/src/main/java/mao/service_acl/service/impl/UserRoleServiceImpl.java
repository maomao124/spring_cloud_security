package mao.service_acl.service.impl;

import mao.service_acl.entity.UserRole;
import mao.service_acl.mapper.UserRoleMapper;
import mao.service_acl.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService
{

}
