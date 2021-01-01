package com.panji.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panji.entity.SysLog;
import com.panji.entity.SysLogExample;
import com.panji.repo.SysLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
        example.setOrderByClause("id desc");
        example.createCriteria().andUsernameLike(name);
        List<SysLog> tbUsers = sysLogRepository.selectByExample(example);
        return tbUsers;
    }

    public List<SysLog> findByWapper(String name) {
        QueryWrapper<SysLog> wrapper = new QueryWrapper<>();
        wrapper.eq("username", name)
                .orderByDesc("id");
        List<SysLog> selectPage = sysLogRepository.selectList(wrapper);
        return selectPage;
    }

    /**
     * Wrapper 分页 - 可用
     *
     * @param page
     * @param name
     * @return
     */
    public Page<SysLog> findByPage(Page page, String name) {
        QueryWrapper<SysLog> wrapper = new QueryWrapper<>();
        wrapper.eq("username", name);
        Page<SysLog> selectPage = sysLogRepository.selectPage(page, wrapper);
        return selectPage;
    }

    public List<SysLog> findByPage2(Pageable page, String name) {
        SysLogExample example = new SysLogExample();
        example.createCriteria().andUsernameLike(name);
        // Mybatis-generate 生成的 Example 自带的分页
        example.setLimit(page.getPageSize());
        example.setOffset(page.getOffset());
        return sysLogRepository.selectByExample(example);
    }
}
