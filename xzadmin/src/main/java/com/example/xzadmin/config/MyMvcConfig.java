package com.example.xzadmin.config;

import com.example.xzadmin.interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //没有数据的页面不需要经过控制器
        registry.addViewController("/").setViewName("index");
        // registry.addViewController("/laypage").setViewName("laypage");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/layuimini-2/page/*");
        //registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/admin/*");
        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/admin/*")
                .excludePathPatterns("/admin/login", "/xzadmin/login");
    }
}
