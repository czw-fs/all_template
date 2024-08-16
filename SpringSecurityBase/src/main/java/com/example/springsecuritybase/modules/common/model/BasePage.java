package com.example.springsecuritybase.modules.common.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BasePage {

    @NotNull
    private int pageNum;

    @NotNull
    private int pageSize;

}
