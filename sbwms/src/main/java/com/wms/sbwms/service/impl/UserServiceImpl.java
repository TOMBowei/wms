package com.wms.sbwms.service.impl;

import com.wms.sbwms.entity.User;
import com.wms.sbwms.mapper.UserMapper;
import com.wms.sbwms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2023-11-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
