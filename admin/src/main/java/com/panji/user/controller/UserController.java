package com.panji.user.controller;

import com.panji.user.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public List<TbUser> hello(String name) {
        List<TbUser> userList = userService.findByName(name);
        return userList;
    }
}
