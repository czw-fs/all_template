package com.example.shiro_test.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;      // 返回码：一般 200 表示成功，其他表示不同的错误类型
    private String message;    // 返回消息，通常用来描述状态或错误信息
    private T data;            // 返回的数据，泛型 T 可以返回不同类型的数据

    /**
     * 返回成功结果
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    /**
     * 返回失败结果
     */
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }
}

