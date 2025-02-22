package com.example.spring_source.demo.validationDemo.globalExceptionHandle;

import com.example.spring_source.demo.validationDemo.dto.ResultInfo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private static final String BAD_REQUEST_MSG = "客户端请求参数错误";

    // <1> 处理 form data方式调用接口校验失败抛出的异常
    @ExceptionHandler(BindException.class)
    public ResultInfo<List<String>> bindExceptionHandler(BindException e) {

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        return ResultInfo.error(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
    }

    // <2> 处理 json 请求体调用接口校验失败抛出的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo<List<String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        return ResultInfo.error(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
    }


    // <3> 处理单个参数校验失败抛出的异常
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultInfo<List<String>> constraintViolationExceptionHandler(ConstraintViolationException e) {

        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

        return ResultInfo.error(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
    }


}
