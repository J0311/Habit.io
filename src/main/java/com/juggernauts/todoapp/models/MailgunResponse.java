package com.juggernauts.todoapp.models;

/**
 * A POJO for taking a response from the Mailgun API
 * @author Jacob
 */

public class MailgunResponse {
    private String id;
    private String message;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
