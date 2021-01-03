package com.panji.sys.data.vo;

import com.panji.enums.TestStatus;
import com.panji.enums.TestType;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("测试 Type")
    private TestType type;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private TestStatus status;
}
