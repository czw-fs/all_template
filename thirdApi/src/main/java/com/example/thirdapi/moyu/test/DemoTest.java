package com.example.thirdapi.moyu.test;

import com.example.thirdapi.moyu.Response.MoyuResp;
import com.example.thirdapi.utils.RestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class DemoTest {

    @Resource
    private RestUtils restUtils;

    /**
     * 摸鱼人日历
     */
    @Test
    public void test() {
        MoyuResp moyuResp = restUtils.getForObject("https://api.vvhan.com/api/moyu?type=json", MoyuResp.class);
        log.info("响应：{}",moyuResp);
    }
}
