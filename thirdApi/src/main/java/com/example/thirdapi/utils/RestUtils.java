package com.example.thirdapi.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestUtils {

    private final RestTemplate restTemplate;

    public String getForString(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    public <T> T getForObject(String url, Class<T> clazz) {
        return restTemplate.getForObject(url, clazz);
    }

}
