package com.example.spring_source.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


@Component
public class MyWebServe implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>, Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8899);
    }
}
