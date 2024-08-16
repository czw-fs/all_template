package com.example.springsecuritybase.modules.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BasePage {

    private int curPage;
    private int size;

    public void toDefaultCurrentAndSize() {
        this.curPage = 1;
        this.size = 10;
    }
}
