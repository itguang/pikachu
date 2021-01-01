package com.panji.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panji.entity.EmunTest;
import com.panji.entity.SysLog;
import com.panji.entity.enums.TestStatus;
import com.panji.entity.enums.TestType;
import com.panji.repo.EmunTestRepository;
import com.panji.sys.data.vo.TestEnumVO;
import com.panji.user.UserService;
import org.springframework.beans.BeanUtils;
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
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmunTestRepository emunTestRepository;

    @GetMapping("/hello")
    public List<SysLog> hello(String name) {
        List<SysLog> userList = userService.findByName(name);
        return userList;
    }

    @GetMapping("/test/enum")
    public TestEnumVO testEnum() {
        EmunTest emunTest = new EmunTest();
        emunTest.setType(TestType.ONE);
        emunTest.setName("测试");
        emunTest.setStatus(TestStatus.SUCCESS);

        emunTestRepository.insert(emunTest);
        EmunTest test = emunTestRepository.selectById(1);
        TestEnumVO testEnumVO = new TestEnumVO();
        BeanUtils.copyProperties(test,testEnumVO);
        return testEnumVO;
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
