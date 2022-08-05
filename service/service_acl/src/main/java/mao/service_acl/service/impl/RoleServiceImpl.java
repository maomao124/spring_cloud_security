package mao.service_acl.service.impl;

import mao.service_acl.entity.Role;
import mao.service_acl.mapper.RoleMapper;
import mao.service_acl.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
