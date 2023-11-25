package com.wms.sbwms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.sbwms.common.QueryPageParam;
import com.wms.sbwms.common.Result;
import com.wms.sbwms.entity.Goods;
import com.wms.sbwms.service.GoodsService;
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
 * @since 2023-11-22
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
//    新增
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        return goodsService.save(goods)?Result.success(1L, goods):Result.fail();
    }
//    修改
    @PostMapping("/update")
    public boolean update(@RequestBody Goods goods){
        return goodsService.updateById(goods);
    }
//    删除
@PostMapping("/delete")
    public Result delete(Integer id){
        return goodsService.removeById(id) ? Result.success(): Result.fail();
    }
//    查询
    @PostMapping("/list")
    public Result list(@RequestBody QueryPageParam queryPageParam){
        HashMap param = queryPageParam.getParam();
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Goods::getName, param.get("name"));
        IPage result = goodsService.myList(page,wrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }

}
