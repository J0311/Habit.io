package com.juggernauts.todoapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MailgunResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link MailgunResponse}
     *   <li>{@link MailgunResponse#setId(String)}
     *   <li>{@link MailgunResponse#setMessage(String)}
     *   <li>{@link MailgunResponse#getId()}
     *   <li>{@link MailgunResponse#getMessage()}
     * </ul>
     */
    @Test
    void testConstructor() {
        MailgunResponse actualMailgunResponse = new MailgunResponse();
        actualMailgunResponse.setId("42");
        actualMailgunResponse.setMessage("Not all who wander are lost");
        assertEquals("42", actualMailgunResponse.getId());
        assertEquals("Not all who wander are lost", actualMailgunResponse.getMessage());
    }
}

