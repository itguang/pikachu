package com.panji.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.panji.domain.SysUser;
import com.panji.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    public Optional<SysUser> findByUserName(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return Optional.ofNullable(sysUserRepository.selectOne(wrapper));
    }

    public void save(SysUser sysUser) {
        sysUserRepository.insert(sysUser);
    }
}
