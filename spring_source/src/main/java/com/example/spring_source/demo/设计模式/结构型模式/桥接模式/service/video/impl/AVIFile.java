package com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.video.impl;

import com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.video.VideoFile;

//avi文件
public class AVIFile implements VideoFile {
    public void decode(String fileName) {
        System.out.println("avi视频文件："+ fileName);
    }
}