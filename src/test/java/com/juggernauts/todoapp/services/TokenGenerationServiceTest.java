package com.juggernauts.todoapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.juggernauts.todoapp.models.User;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TokenGenerationService.class})
@ActiveProfiles({"josh"})
@ExtendWith(SpringExtension.class)
class TokenGenerationServiceTest {
    @Autowired
    private TokenGenerationService tokenGenerationService;

    /**
     * Method under test: {@link TokenGenerationService#generateUserToken(User)}
     */
    @Test
    void testGenerateUserToken() {
        User user = new User();
        user.setCategories(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setEmailVerified(true);
        user.setId(1);
        user.setPassword("iloveyou");
        assertEquals("amFuZS5kb2VAZXhhbXBsZS5vcmc6aWxvdmV5b3U=", tokenGenerationService.generateUserToken(user));
    }
}

