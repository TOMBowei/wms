package com.wms.sbwms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.sbwms.common.QueryPageParam;
import com.wms.sbwms.common.Result;
import com.wms.sbwms.entity.Storage;
import com.wms.sbwms.entity.User;
import com.wms.sbwms.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2023-11-22
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;
    //    新增
    @PostMapping("/save")
    public Result save(@RequestBody Storage storage){
        return storageService.save(storage)?Result.success(1L, storage):Result.fail();
    }
    //    修改
    @PostMapping("/update")
    public boolean update(@RequestBody Storage storage){
        return storageService.updateById(storage);
    }
    //    删除
    @GetMapping("/delete")
    public Result delete(Integer id){
        return storageService.removeById(id)?Result.success():Result.fail();
    }
    //    查询
    @PostMapping("/list")
    public Result list(@RequestBody QueryPageParam queryPageParam){
        HashMap param = queryPageParam.getParam();
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        LambdaQueryWrapper<Storage> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Storage::getName, param.get("name"));
        IPage result = storageService.myPage(page, wrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }
    @GetMapping("/listAll")
    public Result listAll(){
        List list = storageService.list();
        return Result.success(list);
    }
}
