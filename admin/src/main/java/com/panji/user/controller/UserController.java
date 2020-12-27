package com.panji.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panji.entity.SysLog;
import com.panji.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guang
 * @since 2020/12/26 3:12 下午
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public List<SysLog> hello(String name) {
        List<SysLog> userList = userService.findByName(name);
        return userList;
    }

    @GetMapping("/hello1")
    public List<SysLog> hello1(String name) {
        List<SysLog> serviceByPage = userService.findByWapper(name);
        return serviceByPage;
    }

    @GetMapping("/hello2")
    public Page<SysLog> hello2(String name, Page page) {
        Page<SysLog> serviceByPage = userService.findByPage(page, name);
        return serviceByPage;
    }

    @GetMapping("/hello3")
    public List<SysLog> hello3(String name, Pageable page) {
        List<SysLog> serviceByPage = userService.findByPage2(page, name);
        return serviceByPage;
    }
}
