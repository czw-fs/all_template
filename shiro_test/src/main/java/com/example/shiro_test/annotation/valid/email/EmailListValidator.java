package com.example.shiro_test.annotation.valid.email;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailListValidator implements ConstraintValidator<ValidEmailList, List<String>> {
    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if (CollectionUtils.isEmpty(value)) {
            return false;
        }

        // 校验每个元素是否符合Email格式
        for (String email : value) {
            if (StringUtils.isBlank(email) || !email.matches("^[\\w-]+(\\.[\\w-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,})$")) {
                return false;
            }
        }
        return true;
    }
}
