package com.panji.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * sys_user
 * @author 
 */
@ApiModel(value="com.panji.domain.SysUser系统用户表")
@Data
public class SysUser implements Serializable {
    /**
     * sysUserId
     */
    @ApiModelProperty(value="sysUserId")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value="创建者ID")
    private Long operator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime created;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updated;

    /**
     * 是否启用
     */
    @ApiModelProperty(value="是否启用")
    private Boolean isEnbaled;

    private static final long serialVersionUID = 1L;
}