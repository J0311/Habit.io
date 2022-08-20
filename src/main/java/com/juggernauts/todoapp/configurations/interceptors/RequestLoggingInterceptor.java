package com.juggernauts.todoapp.configurations.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * An interceptor for logging pre-handling and after completion events of mappings
 * @author Jacob
 */
public class RequestLoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LogManager.getLogger(RequestLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("[HANDLING] {} request to {} with params={}", request.getMethod(), request.getRequestURI(), request.getParameterMap());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            logger.error("[FAIL] {} request to {}", request.getMethod(), request.getRequestURI(), ex);
        } else {
            logger.info("[SUCCESS] {} request to {}", request.getMethod(), request.getRequestURI());
        }
    }
}
