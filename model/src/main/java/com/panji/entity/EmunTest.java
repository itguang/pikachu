package com.panji.entity;

import com.panji.entity.enums.TestStatus;
import com.panji.entity.enums.TestType;
import lombok.Data;

import java.io.Serializable;

/**
 * emun_test
 *
 * @author
 */
@Data
public class EmunTest implements Serializable {
    private Integer id;

    /**
     * 类型枚举
     */
    private TestType type;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private TestStatus status;

    private static final long serialVersionUID = 1L;
}