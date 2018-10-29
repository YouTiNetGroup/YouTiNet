package com.youti.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.youti.api.interceptor.ProcessInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport{

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ProcessInterceptor()).addPathPatterns("/**");
    }

}
