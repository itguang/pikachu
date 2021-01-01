package com.panji.repo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panji.entity.EmunTest;
import com.panji.entity.EmunTestExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmunTestRepository extends BaseMapper<EmunTest> {
    long countByExample(EmunTestExample example);

    int deleteByExample(EmunTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmunTest record);

    int insertSelective(EmunTest record);

    List<EmunTest> selectByExample(EmunTestExample example);

    EmunTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmunTest record, @Param("example") EmunTestExample example);

    int updateByExample(@Param("record") EmunTest record, @Param("example") EmunTestExample example);

    int updateByPrimaryKeySelective(EmunTest record);

    int updateByPrimaryKey(EmunTest record);
}