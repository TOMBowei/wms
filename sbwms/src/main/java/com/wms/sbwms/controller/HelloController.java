package com.wms.sbwms.controller;

import com.wms.sbwms.entity.User;
import com.wms.sbwms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/hello") // http://localhost:8080/hello
    public String hello() {
        return "Hello World!";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(){
//        return userService.list();
        return userService.selectAll();
    }
}
