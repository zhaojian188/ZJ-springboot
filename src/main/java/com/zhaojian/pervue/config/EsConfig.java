package com.zhaojian.pervue.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class EsConfig {

    //如果与redis整合后出现bug，请放开此注释试试结果
    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

}
