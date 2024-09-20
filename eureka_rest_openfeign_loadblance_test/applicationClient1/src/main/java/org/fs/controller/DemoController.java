package org.fs.controller;

import lombok.RequiredArgsConstructor;
import org.fs.service.AppOpenFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final RestTemplate restTemplate;
    private final AppOpenFeignService appOpenFeignService;


    @RequestMapping("/testRestTemplate")
    public String testRestTemplate() {
        String forObject = restTemplate.getForObject("http://myEurekaApplication1/fs", String.class);
        return forObject;
    }

    @RequestMapping("/testOpenFeign")
    public String testOpenFeign(){
        String show = appOpenFeignService.show();
        return show;
    }
}
