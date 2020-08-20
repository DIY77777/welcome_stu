package com.lthkj.project.welcome_newstu.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 接口返回对象
 * @author 150****1227
 * @date 2020/07/22 14:51
 */
@Data
@AllArgsConstructor   //添加一个构造方法 lombok注解
public class ApiResponse<T> {

    private Boolean success;

    private String message;

    private T data;

    /**
     * 请求成功
     * @author 150****1227
     * @date 2020/07/22 14:51
     */
    public static <T> ApiResponse success(T data) {
        return ApiResponse.success("请求成功", data);
    }

    /**
     * 请求成功
     * @author 150****1227
     * @date 2020/07/22 14:51
     */
    public static <T> ApiResponse success(String message, T data) {
        return new ApiResponse<>(Boolean.TRUE, message, data);
    }

    /**
     * 请求失败
     * @author 150****1227
     * @date 2020/07/22 14:51
     */
    public static ApiResponse failed() {
        return ApiResponse.failed("请求失败");
    }

    /**
     * 请求失败
     * @author 150****1227
     * @date 2020/07/22 14:51
     */
    public static ApiResponse failed(String message) {
        return new ApiResponse<>(Boolean.FALSE, message, null);
    }
}