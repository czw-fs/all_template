package com.example.springsecuritybase.modules.System.dict.model.dto;

import com.example.springsecuritybase.modules.common.model.BasePage;

/**
 * 查询dto
 */
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
