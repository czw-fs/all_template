package com.example.springsecuritybase.modules.test.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Test {
    private Long id;
    private LocalDate createTime;
}
