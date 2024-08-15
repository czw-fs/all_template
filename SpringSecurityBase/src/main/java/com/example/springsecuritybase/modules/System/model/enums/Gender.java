package com.example.springsecuritybase.modules.System.model.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("男"),
    FEMALE("女"),
    OTHER("其他");

    private final String name;

    Gender(String name) {
        this.name = name;
    }
}
