package com.wms.sbwms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.sbwms.common.QueryPageParam;
import com.wms.sbwms.common.Result;
import com.wms.sbwms.entity.User;
import com.wms.sbwms.service.UserService;
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
 * @since 2023-11-08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }
//    新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
//    修改
    @PostMapping("/update")
    public boolean update(@RequestBody User user){
        return userService.updateById(user);
    }
//    新增或修改
    @PostMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
//    删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
//    查询(模糊、匹配)
    @GetMapping("/query")
    public List<User> query(@RequestBody User user){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(user.getName())){
            wrapper.like(User::getName, user.getName());
//            返回模糊查询的结果
            return userService.list(wrapper);
        }
//        wrapper.like(User::getName, user.getName());
//        wrapper.eq(User::getName, user.getName());
        return userService.list(wrapper);
    }
//    分页查询，使用mybatis-plus的分页插件
    @PostMapping("listPage")
    public List<User> listPage(@RequestBody QueryPageParam queryPageParam){
        System.out.println(queryPageParam);
        System.out.println("num == " + queryPageParam.getPageNum());
        System.out.println("size == " + queryPageParam.getPageSize());
        HashMap param = queryPageParam.getParam();
        System.out.println("name == " + param.get("name"));
        System.out.println("no == " + param.get("no"));
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, param.get("name"));
        IPage result = userService.page(page, wrapper);
        System.out.println("total == " + result.getTotal());
        return result.getRecords();
    }
//    分页查询，使用自定义的分页插件，不需要传入wrapper
    @PostMapping("listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam queryPageParam){
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        IPage result = userService.pageC(page);
        System.out.println("total == " + result.getTotal());
        return result.getRecords();
    }
//    分页查询，使用自定义的分页插件，需要传入wrapper
    @PostMapping("listPageCC")
    public List<User> listPageCC(@RequestBody QueryPageParam queryPageParam){
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        HashMap param = queryPageParam.getParam();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, param.get("name"));

        IPage result = userService.pageCC(page, wrapper);
        System.out.println("total == " + result.getTotal());
        return result.getRecords();
    }
//    封装返回数据类型
    @PostMapping("listPageC1")
    public Result listPageC1(@RequestBody QueryPageParam queryPageParam){
        System.out.println(queryPageParam);
        System.out.println("num == " + queryPageParam.getPageNum());
        System.out.println("size == " + queryPageParam.getPageSize());
        HashMap param = queryPageParam.getParam();
        System.out.println("name == " + param.get("name"));
        System.out.println("no == " + param.get("no"));
        Page page = new Page(queryPageParam.getPageNum(), queryPageParam.getPageSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, param.get("name"));
        IPage result = userService.page(page, wrapper);
        System.out.println("total == " + result.getTotal());
        return Result.success(result.getTotal(),result.getRecords());
    }
}
