package com.apps.interceptors.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info(">>>>> Interceptor RequestInterceptor is executing preHandle() method...");

        String ip = request.getHeader("X-FORWARDED-FOR");
        String ipAddress = (ip == null) ? request.getRemoteAddr() : ip;

        LOGGER.info(">>>>> Interceptor RequestInterceptor preHandle() method extracted " +
                "IP address from request: {}", ipAddress);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        LOGGER.info(">>>>> Interceptor RequestInterceptor is executing postHandle() method...");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        LOGGER.info(">>>>> Interceptor RequestInterceptor is executing afterCompletion() method...");

    }
}
