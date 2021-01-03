package com.panji.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * sys_user_role
 * @author 
 */
@Data
public class SysUserRole implements Serializable {
    private Long id;

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 创建者ID
     */
    private Long operator;

    private LocalDateTime created;

    private LocalDateTime updated;

    private static final long serialVersionUID = 1L;
}