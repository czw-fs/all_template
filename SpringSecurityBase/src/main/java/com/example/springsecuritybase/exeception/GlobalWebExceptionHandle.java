package com.example.springsecuritybase.exeception;

import com.example.springsecuritybase.modules.common.model.Result;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalWebExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletResponse response, Exception e) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        log.error("服务器异常", e);
        return Result.error(e.toString());
    }

}
