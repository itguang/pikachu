package com.panji.data;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author guang
 * @since 2021/1/1 5:57 下午
 */
@Data
public class JsonResult<T> {

    private boolean success;

    private Optional<T> data = Optional.empty();

    private Optional<Integer> errCode = Optional.empty();

    private Optional<String> errMessage = Optional.empty();

    private JsonResult() {
    }

    public static <T> JsonResult<T> ok() {
        JsonResult<T> result = new JsonResult();
        result.setSuccess(true);
        return result;
    }

    public static <T> JsonResult<T> ok(@NotNull T data) {
        JsonResult<T> result = new JsonResult();
        result.setSuccess(true);
        result.setData(Optional.of(data));
        return result;
    }

    public static <T> JsonResult<T> ok(@NotNull Optional<T> data) {
        JsonResult<T> result = new JsonResult();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> JsonResult<T> error() {
        return error(Errors.SERVER_ERROR);
    }

    public static <T> JsonResult<T> error(String errorMessage) {
        return error(Errors.SERVER_ERROR.getCode(), errorMessage);
    }

    public static <T> JsonResult<T> error(Error error) {
        return error(error.getCode(), error.getMessage());
    }

    public static <T> JsonResult<T> error(Integer errorCode, String errorMessage) {
        JsonResult<T> result = new JsonResult();
        result.setErrCode(Optional.of(errorCode));
        result.setErrMessage(Optional.ofNullable(errorMessage));
        return result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Optional<T> getData() {
        return this.data;
    }

    public void setData(Optional<T> data) {
        this.data = data;
    }

    public Optional<Integer> getErrCode() {
        return this.errCode;
    }

    public void setErrCode(Optional<Integer> errCode) {
        this.errCode = errCode;
    }

    public Optional<String> getErrMessage() {
        return this.errMessage;
    }

    public void setErrMessage(Optional<String> errMessage) {
        this.errMessage = errMessage;
    }
}
