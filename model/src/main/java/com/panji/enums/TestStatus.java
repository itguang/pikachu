package com.panji.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TestStatus implements IEnum<Integer> {
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    PROCESS(3, "进行中..."),
    ;

    private final int code;

    private final String name;

    // 使用继承接口的方式,指定持久化时使用的值
    @Override
    public Integer getValue() {
        return this.code;
    }
}
