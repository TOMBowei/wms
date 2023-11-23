package com.wms.sbwms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.sbwms.common.QueryPageParam;
import com.wms.sbwms.common.Result;
import com.wms.sbwms.entity.Goodstype;
import com.wms.sbwms.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2023-11-22
 */
@RestController
@RequestMapping("/goodstype")
public class GoodstypeController {

    @Autowired
    private GoodstypeService goodstypeService;
//    新增
    @PostMapping("/save")
    public Result save(@RequestBody Goodstype goodstype){
        return goodstypeService.save(goodstype)?Result.success(1L, goodstype):Result.fail();
    }
//    修改
    @PostMapping("/update")
    public boolean update(@RequestBody Goodstype goodstype){
        return goodstypeService.updateById(goodstype);
    }
//    删除
    @GetMapping("/delete")
    public Result delete(Integer id){
        return goodstypeService.removeById(id) ? Result.success(): Result.fail();
    }
//    查询
    @PostMapping("/list")
    public Result list(@RequestBody QueryPageParam queryPageParam){
        HashMap param = queryPageParam.getParam();
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        LambdaQueryWrapper<Goodstype> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Goodstype::getName, param.get("name"));
        IPage result = goodstypeService.myList(page, wrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }
}
