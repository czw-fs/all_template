package com.example.springsecuritybase.modules.System.dict.model.dto;

import com.example.springsecuritybase.modules.common.model.BasePage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 查询dto
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class DictSearchDto extends BasePage {

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
}
