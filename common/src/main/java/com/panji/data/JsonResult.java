package com.panji.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author guang
 * @since 2021/1/1 5:57 下午
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult<T> implements Serializable {

    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;

    @ApiModelProperty(value = "响应数据", required = false, notes = "为空的时候不存在")
    private T data;

    @ApiModelProperty(value = "错误码", required = false, notes = "为空的时候不存在")
    private Integer errCode;

    @ApiModelProperty(value = "错误信息", required = false, notes = "为空的时候不存在")
    private String errMessage;

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
        result.setErrCode(errorCode);
        result.setErrMessage(errorMessage);
        return result;
    }
}
