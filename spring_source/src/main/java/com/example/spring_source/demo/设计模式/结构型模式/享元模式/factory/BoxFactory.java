package com.example.spring_source.demo.设计模式.结构型模式.享元模式.factory;

import com.example.spring_source.demo.设计模式.结构型模式.享元模式.entity.AbstractBox;
import com.example.spring_source.demo.设计模式.结构型模式.享元模式.entity.impl.IBox;
import com.example.spring_source.demo.设计模式.结构型模式.享元模式.entity.impl.LBox;
import com.example.spring_source.demo.设计模式.结构型模式.享元模式.entity.impl.OBox;

import java.util.HashMap;

public class BoxFactory {

    private static HashMap<String, AbstractBox> map;

    public BoxFactory() {
        map = new HashMap<String, AbstractBox>();

        AbstractBox iBox = new IBox();
        AbstractBox lBox = new LBox();
        AbstractBox oBox = new OBox();

        map.put("I", iBox);
        map.put("L", lBox);
        map.put("O", oBox);
    }

    public static final BoxFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final BoxFactory INSTANCE = new BoxFactory();
    }

    public AbstractBox getBox(String key) {
        return map.get(key);
    }
}