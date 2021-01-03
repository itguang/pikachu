package com.panji.sys.controller;

import com.panji.data.JsonResult;
import com.panji.domain.SysUser;
import com.panji.domain.SysUserExample;
import com.panji.repository.SysUserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.panji.sys.SysRoute.SYS_USER;

/**
 * @author guang
 * @since 2020/12/26 3:12 下午
 */
@RestController
@Api(tags = "系统模块")
public class SysController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @ApiOperation("用户列表")
    @GetMapping(SYS_USER)
    public JsonResult<List<SysUser>> findUser() {
        List<SysUser> sysUsers = sysUserRepository.selectByExample(new SysUserExample());
        return JsonResult.ok(sysUsers);
    }

}
