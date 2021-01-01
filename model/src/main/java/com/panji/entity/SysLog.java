package com.panji.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_log
 * @author 
 */
@ApiModel(value = "SysLog系统日志")
@Data
public class SysLog implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 用户操作
     */
    @ApiModelProperty(value="用户操作")
    private String operation;

    /**
     * 请求方法
     */
    @ApiModelProperty(value="请求方法")
    private String method;

    /**
     * 请求参数
     */
    @ApiModelProperty(value="请求参数")
    private String params;

    /**
     * 执行时长(毫秒)
     */
    @ApiModelProperty(value="执行时长(毫秒)")
    private Long time;

    /**
     * IP地址
     */
    @ApiModelProperty(value="IP地址")
    private String ip;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;
}