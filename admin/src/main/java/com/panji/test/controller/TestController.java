package com.panji.test.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panji.data.JsonResult;
import com.panji.entity.EmunTest;
import com.panji.entity.SysLog;
import com.panji.entity.enums.TestStatus;
import com.panji.entity.enums.TestType;
import com.panji.repo.EmunTestRepository;
import com.panji.test.UserService;
import com.panji.test.vo.TestEnumVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
// Swagger 基于 Tag 来分组,Tag 相同的在同一个组
@Api(value = "测试 模块", tags = "测试 Tag", consumes = "测试 Consume")
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmunTestRepository emunTestRepository;

    @GetMapping("/hello")
    @ApiOperation("测试 1")
    public JsonResult<List<SysLog>> hello(@ApiParam("用户名") String name) {
        List<SysLog> userList = userService.findByName(name);
        return JsonResult.ok(userList);
    }

    @GetMapping("/test/enum")
    @ApiOperation(value = "测试枚举值的持久化", notes = "枚举的持久化和传入都需要特殊处理")
    public JsonResult<TestEnumVO> testEnum() {
        EmunTest emunTest = new EmunTest();
        emunTest.setType(TestType.ONE);
        emunTest.setName("测试");
        emunTest.setStatus(TestStatus.SUCCESS);

        emunTestRepository.insert(emunTest);
        EmunTest test = emunTestRepository.selectById(1);
        TestEnumVO testEnumVO = new TestEnumVO();
        BeanUtils.copyProperties(test, testEnumVO);
        return JsonResult.ok(testEnumVO);
    }

    @GetMapping("/hello1")
    @ApiOperation("查询 By Wapper")
    public JsonResult<List<SysLog>> hello1(@ApiParam("用户名") String name) {
        List<SysLog> serviceByPage = userService.findByWapper(name);
        return JsonResult.ok(serviceByPage);
    }

    @GetMapping("/hello2")
    @ApiOperation(value = "分页 By Wapper", notes = "该分页可以返回总页数")
    public JsonResult<Page<SysLog>> hello2(@ApiParam("用户名") String name, Page page) {
        Page<SysLog> serviceByPage = userService.findByPage(page, name);
        return JsonResult.ok(serviceByPage);
    }

    @GetMapping("/hello3")
    @ApiOperation(value = "分页ByExample", notes = "该分页支持流分页")
    public JsonResult<List<SysLog>> hello3(String name, Pageable page) {
        List<SysLog> serviceByPage = userService.findByPage2(page, name);
        return JsonResult.ok(serviceByPage);
    }
}
