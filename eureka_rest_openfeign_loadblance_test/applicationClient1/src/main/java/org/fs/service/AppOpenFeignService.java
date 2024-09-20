package org.fs.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "myEurekaApplication1")
public interface AppOpenFeignService {
    @RequestMapping("/fs")
    String show();
}
