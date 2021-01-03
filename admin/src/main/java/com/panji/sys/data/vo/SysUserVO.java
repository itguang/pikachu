package com.panji.sys.data.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysUserVO {

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
}
