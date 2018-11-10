package com.youti.api.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.youti.api.interceptor.ProcessInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport{

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ProcessInterceptor()).addPathPatterns("/**");
    }
    
    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
    StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
    return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    super.configureMessageConverters(converters);

    converters.add(responseBodyConverter());
    }

}