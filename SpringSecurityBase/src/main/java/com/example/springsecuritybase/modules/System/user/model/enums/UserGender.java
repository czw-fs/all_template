package com.example.springsecuritybase.modules.System.user.model.enums;

import lombok.Getter;

@Getter
public enum UserGender {

    MALE("男"),
    FEMALE("女")
    ;

    private final String name;

    UserGender(String name){
        this.name = name;
    }

}
