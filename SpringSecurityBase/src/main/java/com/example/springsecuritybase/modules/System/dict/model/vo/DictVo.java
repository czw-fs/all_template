package com.example.springsecuritybase.modules.System.dict.model.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DictVo {
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 唯一编码
     */
    @NotBlank(message = "唯一编码不能为空")
    private String code;
    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String status;
    /**
     * 说明
     */
    private String remark;
}
