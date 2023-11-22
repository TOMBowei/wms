package com.wms.sbwms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.sbwms.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.sbwms.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2023-11-22
 */
public interface StorageService extends IService<Storage> {

//    自定义查询方法
    IPage myPage(IPage<Storage> page, Wrapper<Storage> wrapper);
}
