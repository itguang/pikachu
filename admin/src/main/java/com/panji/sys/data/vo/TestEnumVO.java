package com.panji.sys.data.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.panji.entity.enums.TestStatus;
import com.panji.entity.enums.TestType;
import com.panji.jackson.EnumToListSerializer;
import lombok.Data;

/**
 * @author guang
 * @since 2021/1/1 12:47 下午
 */
@Data
public class TestEnumVO {
    private Integer id;

    /**
     * 类型枚举
     */
    @JsonSerialize(using = EnumToListSerializer.class)
    private TestType type;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    @JsonSerialize(using = EnumToListSerializer.class)
    private TestStatus status;
}
