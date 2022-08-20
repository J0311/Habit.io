package com.juggernauts.todoapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Method under test: {@link User#User(int, String, String)}
     */
    @Test
    void testConstructor() {
        User actualUser = new User(1, "iloveyou", "jane.doe@example.org");

        assertNull(actualUser.getCategories());
        assertFalse(actualUser.isEmailVerified());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals(1, actualUser.getId());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
    }

    /**
     * Method under test: {@link User#User(int, String, String, boolean)}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User(1, "iloveyou", "jane.doe@example.org", true);

        assertNull(actualUser.getCategories());
        assertTrue(actualUser.isEmailVerified());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals(1, actualUser.getId());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
    }
}

