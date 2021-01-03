package com.panji.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建者ID
     */
    private Long operator;

    private LocalDateTime created;

    private LocalDateTime updated;

    private static final long serialVersionUID = 1L;
}