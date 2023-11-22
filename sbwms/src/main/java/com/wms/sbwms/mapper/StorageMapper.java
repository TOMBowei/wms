package com.wms.sbwms.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wms.sbwms.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.sbwms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wms
 * @since 2023-11-22
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

    IPage myPage(IPage<Storage> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
