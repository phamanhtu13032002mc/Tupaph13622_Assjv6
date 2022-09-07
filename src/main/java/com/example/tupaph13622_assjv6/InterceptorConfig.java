package com.example.tupaph13622_assjv6;

import com.example.tupaph13622_assjv6.intercepter.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    GlobalInterceptor globalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor)
                .addPathPatterns("/**").
                addPathPatterns("/rest/**", "/admin/**", "/assets/**");
        //con cac
    }
}
