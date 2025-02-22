package com.example.shiro_test.handle;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.shiro_test.model.Result;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ShiroExceptionHandler {

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result handle401(ShiroException e) {
        return Result.error(401, e.getMessage());
    }

    // 捕捉未认证的异常
    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result handle401(UnauthenticatedException e) {
        return Result.error(401, e.getMessage());
    }
    
    // 捕捉token过期异常
    @ExceptionHandler(value = TokenExpiredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleTokenExpired(TokenExpiredException e) {
        return Result.error(500, e.getMessage());
    }

}
