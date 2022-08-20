package com.juggernauts.todoapp.configurations;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles({"josh"})
@ExtendWith(SpringExtension.class)
class WebSecurityConfigTest {
    @Autowired
    private WebSecurityConfig webSecurityConfig;

    /**
     * Method under test: {@link WebSecurityConfig#filterChain(HttpSecurity)}
     */
    @Test
    void testFilterChain() throws Exception {
        assertTrue(webSecurityConfig.filterChain(null) instanceof DefaultSecurityFilterChain);
    }
}

