package com.panji.dao;

import generator.SysRole;
import generator.SysRoleExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.SysRole
 */
/**
 * SysRoleDao继承基类
 */
@Mapper
public interface SysRoleDao extends MyBatisBaseDao<SysRole, Long, SysRoleExample> {
}