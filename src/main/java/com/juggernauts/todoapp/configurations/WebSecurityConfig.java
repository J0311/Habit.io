package com.juggernauts.todoapp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * A configuration to set up web authentication system
 * @author Jacob
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    /**
     * Sets the HTTP filters for authentication
     * @param http The security protocols
     * @return The built HTTP filters
     * @throws Exception If there is an exception within the HTTP chain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // setup /logout endpoint
            .logout().invalidateHttpSession(true).logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).and()
            
            // required things for access to endpoints
            .cors().and()
            .csrf().disable();
            
        return http.build();
    }
}
