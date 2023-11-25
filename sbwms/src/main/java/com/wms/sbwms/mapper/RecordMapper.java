package com.wms.sbwms.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wms.sbwms.entity.Goods;
import com.wms.sbwms.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wms
 * @since 2023-11-25
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    IPage myList(IPage<Record> page, @Param(Constants.WRAPPER) Wrapper<Record> wrapper);

}
