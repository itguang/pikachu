package com.panji.data;

/**
 * @author guang
 * @since 2021/1/1 9:14 下午
 */
public class DomainError implements Error {
    private int code;
    private String message;

    public DomainError(int code, String message) {
        if (code < 100) {
            throw new IllegalArgumentException(String.format("DomainError 错误码[%d]超出范围（>= 100）", code));
        } else {
            this.code = code;
            this.message = message;
        }
    }

    public static DomainError with(int code, String message) {
        return new DomainError(code, message);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
