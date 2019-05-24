package com.sera.wellness.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@PropertySource("classpath:application.properties")
@Configuration
public class ResourceHandlerConffig extends WebMvcConfigurationSupport {
    @Resource
    private Environment environment;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + environment.getProperty("path.uploads"));
        System.out.println(environment.getProperty("path.uploads"));
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
