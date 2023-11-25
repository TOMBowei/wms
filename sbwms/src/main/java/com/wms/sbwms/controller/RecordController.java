package com.wms.sbwms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.sbwms.common.QueryPageParam;
import com.wms.sbwms.common.Result;
import com.wms.sbwms.entity.Goods;
import com.wms.sbwms.entity.Record;
import com.wms.sbwms.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2023-11-25
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;
    @PostMapping("/list")
    public Result list(@RequestBody QueryPageParam queryPageParam){
        HashMap param = queryPageParam.getParam();
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.apply(" a.goods = b.id and b.storage = c.id and b.goodsType = d.id ");
        wrapper.like("b.name", param.get("name"));
        IPage result = recordService.myList(page,wrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }

}
