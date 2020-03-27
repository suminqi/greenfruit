package com.monster.greenfruit.config;

import com.monster.greenfruit.interceptor.ResourceInterceptor;
import com.monster.greenfruit.interceptor.SessionAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@PropertySource(value = "classpath:interceptor.properties")

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${SessionAuthenticationInterceptor.ExcludeUrl}")
    private String sessionAuthenticationInterceptorExcludeUrl;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ResourceInterceptor())
                .excludePathPatterns("/static/**");

    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/greenfruit/admin/admin/page/login")
                .setViewName("login");
    }
}
