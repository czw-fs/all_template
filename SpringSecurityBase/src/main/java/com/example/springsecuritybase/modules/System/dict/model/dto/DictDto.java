package com.example.springsecuritybase.modules.System.dict.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DictDto {
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 唯一编码
     */
    private String code;
    /**
     * 状态
     */
    private String status;
    /**
     * 说明
     */
    private String remark;
}
