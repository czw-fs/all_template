package com.example.spring_source.demo.validationDemo.customValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 具体自定义校验时间类
 */
public class HaveNoBlankValidator implements ConstraintValidator<HaveNoBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // null 不做检验
        if (value == null) {
            return true;
        }
        if (value.contains(" ")) {
            // 校验失败
            return false;
        }
        // 校验成功
        return true;
    }
}