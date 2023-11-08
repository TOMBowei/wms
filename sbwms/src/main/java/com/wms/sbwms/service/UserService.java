package com.wms.sbwms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.sbwms.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectAll();
}
