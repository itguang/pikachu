package com.panji.sys;

import codegenerator.sys.service.impl.LogServiceImpl;
import generator.TbUser;
import com.panji.dao.TbUserDao;
import generator.TbUserExample;
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
    private TbUserDao tbUserDao;

    @Autowired
    private LogServiceImpl logService;

    public List<TbUser> findByName(String name) {
        TbUserExample example = new TbUserExample();
        example.createCriteria().andUsernameLike(name);
        List<TbUser> tbUsers = tbUserDao.selectByExample(example);
        return tbUsers;
    }

}
