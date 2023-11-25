package com.wms.sbwms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.sbwms.entity.Goods;
import com.wms.sbwms.entity.Record;
import com.wms.sbwms.mapper.GoodsMapper;
import com.wms.sbwms.mapper.RecordMapper;
import com.wms.sbwms.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2023-11-25
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Resource
    private RecordMapper recordMapper;

    @Override
    public IPage myList(IPage<Record> page, Wrapper<Record> wrapper) {
        return recordMapper.myList(page, wrapper);
    }
}
