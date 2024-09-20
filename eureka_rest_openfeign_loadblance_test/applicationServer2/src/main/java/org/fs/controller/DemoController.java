package org.fs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/fs")
    public String show(){
        return "applicationServer2";
    }
}
