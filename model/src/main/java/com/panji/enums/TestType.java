package com.panji.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TestType {
    ONE(1, "一"),
    TWO(2, "二");

    // 使用注解方式,标注持久化时使用哪个字段入库
    @EnumValue
    private final int code;

    private final String name;
}
