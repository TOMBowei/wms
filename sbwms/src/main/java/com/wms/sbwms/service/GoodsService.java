package com.wms.sbwms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.sbwms.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.sbwms.entity.Goodstype;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2023-11-22
 */
public interface GoodsService extends IService<Goods> {

    IPage myList(IPage<Goods> page, Wrapper<Goods> wrapper);

}
