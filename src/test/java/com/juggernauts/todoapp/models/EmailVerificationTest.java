package com.juggernauts.todoapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class EmailVerificationTest {
    /**
     * Method under test: {@link EmailVerification#EmailVerification(String, User)}
     */
    @Test
    void testConstructor() {
        User user = new User();
        ArrayList<Category> categoryList = new ArrayList<>();
        user.setCategories(categoryList);
        user.setEmail("jane.doe@example.org");
        user.setEmailVerified(true);
        user.setId(1);
        user.setPassword("iloveyou");
        EmailVerification actualEmailVerification = new EmailVerification("ABC123", user);

        assertEquals("ABC123", actualEmailVerification.getToken());
        User user1 = actualEmailVerification.getUser();
        assertSame(user, user1);
        assertEquals(0, actualEmailVerification.getTokenId());
        assertTrue(user1.isEmailVerified());
        assertEquals("iloveyou", user1.getPassword());
        assertEquals(1, user1.getId());
        assertEquals("jane.doe@example.org", user1.getEmail());
        List<Category> categories = user1.getCategories();
        assertSame(categoryList, categories);
        assertTrue(categories.isEmpty());
    }
}

