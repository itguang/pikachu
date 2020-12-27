package codegenerator.sys.service.impl;

import codegenerator.sys.entity.Log;
import codegenerator.sys.mapper.LogMapper;
import codegenerator.sys.service.ILogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author guang
 * @since 2020-12-27
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Autowired
    private LogMapper logMapper;

    public void test(String username, LocalDateTime created) {
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username)
                .ge("createDate", created);
        logMapper.selectOne(wrapper);

    }

    public Page<Log> findByPage(Page page) {
        QueryWrapper<Log> wrapper = new QueryWrapper<>();

        Page<Log> selectPage = logMapper.selectPage(page, wrapper);
        return selectPage;
    }

}
