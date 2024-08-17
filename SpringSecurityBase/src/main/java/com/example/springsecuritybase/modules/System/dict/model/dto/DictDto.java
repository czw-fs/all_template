package com.example.springsecuritybase.modules.System.dict.model.dto;

import com.example.springsecuritybase.modules.common.validation.group.CreateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DictDto {
    /**
     * id
     */
    @Null(message = "新建时id应为空",groups = CreateGroup.class)
    private Long id;
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
