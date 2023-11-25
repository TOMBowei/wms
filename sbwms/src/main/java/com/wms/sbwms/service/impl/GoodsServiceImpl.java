package com.wms.sbwms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.sbwms.entity.Goods;
import com.wms.sbwms.entity.Goodstype;
import com.wms.sbwms.mapper.GoodsMapper;
import com.wms.sbwms.mapper.GoodstypeMapper;
import com.wms.sbwms.service.GoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public IPage myList(IPage<Goods> page, Wrapper<Goods> wrapper) {
        return goodsMapper.myList(page, wrapper);
    }

}
