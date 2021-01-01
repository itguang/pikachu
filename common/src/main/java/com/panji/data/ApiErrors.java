package com.panji.data;

public interface ApiErrors {
    ApiError BASE_NOT_FOUND = ApiError.with(2, "资源不存在");
    ApiError BASE_UNAUTHORIZED = ApiError.with(3, "未授权");
    ApiError BASE_FORBIDDEN = ApiError.with(4, "拒绝访问");
    ApiError BASE_BAD_PARAMS = ApiError.with(5, "请求参数错误");
}
