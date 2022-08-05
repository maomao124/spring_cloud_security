package mao.service_acl.service.impl;

import mao.service_acl.entity.Permission;
import mao.service_acl.mapper.PermissionMapper;
import mao.service_acl.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author mao
 * @since 2022-08-05
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
