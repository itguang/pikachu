package codegenerator.sys.mapper;

import codegenerator.sys.entity.Log;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @author guang
 * @since 2020-12-27
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {

}
