package com.example.spring_source.demo.validationDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo<T>{
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 错误消息
     */
    private T data;

    public static <T> ResultInfo<T> error(int code, String message, T data) {
        return new ResultInfo<>(code, message, data);
    }
}