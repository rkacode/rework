package com.blogspot.rkacode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("WEB-INF/beans.xml")
@ComponentScan(basePackages = "com.blogspot.rkacode")
public class Config {
    
}
