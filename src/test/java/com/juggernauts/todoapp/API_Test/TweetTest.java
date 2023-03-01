package com.juggernauts.todoapp.API_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.juggernauts.todoapp.utils.Tweet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TweetTest {
    /**
     * Method under test: default or parameterless constructor of {@link Tweet}
     * Twitter API
     */
    
    @Test
    void testConstructor() {
        assertEquals("I stay on task with the ToDoApp from Habit.ual. Download the app today!", (new Tweet()).tw);
    }
//
    /**
     * Successfully post/updates the user Twitter status and returns status update message
     */
    
    @org.junit.Test
    public void shouldSuccessfullyUpdateTwitterStatus() {
        Tweet tw = new Tweet();
        String status = "I'm the Juggernaut and I love APIs!";
        assertEquals("Successfully updated the status in Twitter.", tw.shareApp(status));

    }
}
