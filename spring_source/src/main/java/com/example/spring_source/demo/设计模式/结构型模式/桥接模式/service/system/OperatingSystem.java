package com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.system;

import com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.video.VideoFile;

//操作系统版本
public abstract class OperatingSystem {

    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}