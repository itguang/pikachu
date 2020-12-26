package com.panji.dao;

import generator.TbUser;
import generator.TbUserExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.TbUser
 */

/**
 * TbUserDao继承基类
 */
@Mapper
public interface TbUserDao extends MyBatisBaseDao<TbUser, Long, TbUserExample> {
}