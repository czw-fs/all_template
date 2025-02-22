package com.example.spring_source.demo.validationDemo.dto;

import com.example.spring_source.demo.validationDemo.customValidation.HaveNoBlank;
import com.example.spring_source.demo.validationDemo.group.CreateGroup;
import com.example.spring_source.demo.validationDemo.group.UpdateGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BaseDto {

    @Max(value = 10,message = "长度不能大于10",groups = UpdateGroup.class)
    @NotNull(message = "id不能为空",groups = UpdateGroup.class)
    private Long id;

    @NotBlank(message = "name不能为空",groups = CreateGroup.class)
    private String name;

    @Min(value = 1,message = "other不能小于1")
    @NotNull(message = "other不能为空")
    private Integer other;

    /**
     * 自定义校验
     */
    @HaveNoBlank
    private String test;

    /**
     * 递归校验
     */
    @Valid
    private SonDto sonDto;
}

/**
 * @NotNull 不为null
 * @Null 为null
 * @NotBlank 不为null并且包含至少一个非空白字符
 * @NotEmpty 不为null并且不为空
 * @Pattern 必须满足正则表达式
 *
 * @DecimalMax 小于等于给定的值
 * @DecimalMin 大于等于给定的值
 *
 * @Max 最大值
 * @Min 最小值
 * @Digits 可设定最大整数位数和最大小数位数
 *
 * @Future 必须是将来的时间
 * @FutureOrPresent 当前或将来时间
 * @Past 必须是过去的时间
 * @PastOrPresent 必须是过去的时间，包含现在
 *
 * @AssertFalse 必须是false
 * @AssertTrue 必须是true
 *
 * @Negative 负数（不包括0）
 * @NegativeOrZero 负数或0
 * @PositiveOrZero 正数或0
 * @Positive 正数（不包括0）
 *

 *
 * @Email 校验是否符合Email格式
 * @Size 校验容器的元素个数
 * @Valid	任何非原子类型	指定递归验证关联的对象
 */