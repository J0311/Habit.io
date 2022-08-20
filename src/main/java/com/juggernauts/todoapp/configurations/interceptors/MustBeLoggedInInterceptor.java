package com.juggernauts.todoapp.configurations.interceptors;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * An interceptor for managing access to authenticated endpoints
 * @author Jacob
 */
public class MustBeLoggedInInterceptor implements HandlerInterceptor {
    private static final String[] UNAUTHENTICATED_ENDPOINTS = {"/login", "/logout", "/register", "/error", "/verify"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // if the request URI matches any unauthenticated endpoint, then continue with the handling
        if (Arrays.stream(UNAUTHENTICATED_ENDPOINTS).anyMatch(s -> request.getRequestURI().startsWith(s)))
            return true;
            
        // check if the user session has a user attributed to it
        // this user is attributed to a session upon successful login
        HttpSession session = request.getSession(true);
        if (session.getAttribute("USER") != null)
            return true;
        
        // no user found, reject access
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("You must log in to access this endpoint.");
        return false;
    }
}
