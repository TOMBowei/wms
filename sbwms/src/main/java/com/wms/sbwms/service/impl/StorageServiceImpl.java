package com.wms.sbwms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.sbwms.entity.Storage;
import com.wms.sbwms.entity.User;
import com.wms.sbwms.mapper.StorageMapper;
import com.wms.sbwms.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2023-11-22
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public IPage myPage(IPage<Storage> page, Wrapper<Storage> wrapper) {
        return storageMapper.myPage(page, wrapper);
    }

}
