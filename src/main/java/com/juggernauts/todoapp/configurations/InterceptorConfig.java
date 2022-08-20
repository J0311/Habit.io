package com.juggernauts.todoapp.configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.juggernauts.todoapp.configurations.interceptors.MustBeLoggedInInterceptor;
import com.juggernauts.todoapp.configurations.interceptors.RequestLoggingInterceptor;

/**
 * Configures MVC to add our interceptors
 * @author Jacob
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
  private static final Logger logger = LogManager.getLogger(InterceptorConfig.class);

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    logger.info("registering interceptors");

    addInterceptorVarargs(registry, 
      new RequestLoggingInterceptor(),
      new MustBeLoggedInInterceptor()
    );
  }

  private void addInterceptorVarargs(InterceptorRegistry registry, HandlerInterceptor... interceptors) {
    for (HandlerInterceptor interceptor : interceptors) {
      registry.addInterceptor(interceptor);
      logger.info("registered {}", interceptor.getClass().getSimpleName());
    }
  }
}
