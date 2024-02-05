package com.apps.interceptors.interceptor.configs;

import com.apps.interceptors.interceptor.HeadersInjectorInterceptor;
import com.apps.interceptors.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

    private final RequestInterceptor requestInterceptor;
    private final HeadersInjectorInterceptor headersInjectorInterceptor;

    @Autowired
    public InterceptorsConfig(RequestInterceptor requestInterceptor, HeadersInjectorInterceptor headersInjectorInterceptor) {
        this.requestInterceptor = requestInterceptor;
        this.headersInjectorInterceptor = headersInjectorInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(requestInterceptor);
        registry.addInterceptor(headersInjectorInterceptor);
    }

}
