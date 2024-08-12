package com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.system.impl;

import com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.system.OperatingSystem;
import com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.video.VideoFile;

//mac版本
public class Mac extends OperatingSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    public void play(String fileName) {
		videoFile.decode(fileName);
    }
}