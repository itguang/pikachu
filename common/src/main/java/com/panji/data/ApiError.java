package com.panji.data;

/**
 * @author guang
 * @since 2021/1/1 9:10 下午
 */
public class ApiError implements Error {
    private int code;
    private String message;

    public ApiError(int code, String message) {
        if (code >= 1 && code <= 99) {
            this.code = code;
            this.message = message;
        } else {
            throw new IllegalArgumentException(String.format("ApiError 错误码[%d]超出范围（1～99）", code));
        }
    }

    public static ApiError with(int code, String message) {
        return new ApiError(code, message);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
