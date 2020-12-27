package com.panji.user;

import com.panji.entity.SysLog;
import com.panji.entity.SysLogExample;
import com.panji.repo.SysLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guang
 * @since 2020/12/26 3:16 下午
 */
@Service
public class UserService {

    @Autowired
    private SysLogRepository sysLogRepository;

    public List<SysLog> findByName(String name) {
        SysLogExample example = new SysLogExample();
        example.createCriteria().andUsernameLike(name);
        List<SysLog> tbUsers = sysLogRepository.selectByExample(example);
        return tbUsers;
    }
}
