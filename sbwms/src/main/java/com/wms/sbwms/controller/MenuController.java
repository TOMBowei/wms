package com.wms.sbwms.controller;


import com.wms.sbwms.common.Result;
import com.wms.sbwms.entity.Menu;
import com.wms.sbwms.entity.User;
import com.wms.sbwms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2023-11-16
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @GetMapping("/list")
    public Result list(@RequestParam String roleId){
        List list = menuService.lambdaQuery().like(Menu::getMenuright,roleId).list();
        return Result.success(list);
    }
}
