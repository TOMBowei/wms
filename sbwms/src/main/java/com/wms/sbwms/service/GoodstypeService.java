package com.wms.sbwms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.sbwms.entity.Goods;
import com.wms.sbwms.entity.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2023-11-22
 */
public interface GoodstypeService extends IService<Goodstype> {

    IPage myList(IPage<Goodstype> page, Wrapper<Goodstype> wrapper);
}
