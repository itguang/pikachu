package com.panji.sys.controller;

import codegenerator.sys.entity.Log;
import codegenerator.sys.service.impl.LogServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panji.sys.UserService;
import generator.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guang
 * @since 2020/12/26 3:12 下午
 */
@RestController
public class SysController {
    @Autowired
    private UserService userService;

    @Autowired
    private LogServiceImpl logService;

    @GetMapping("/hello")
    public List<TbUser> hello(String name) {
        List<TbUser> userList = userService.findByName(name);
        return userList;
    }

    @GetMapping("/log")
    public Page<Log> findLog(Page page) {
        Page<Log> logPage = logService.findByPage(page);
        return logPage;
    }
}
