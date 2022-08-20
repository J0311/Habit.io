package com.juggernauts.todoapp.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.juggernauts.todoapp.clients.MailgunClient;
import com.juggernauts.todoapp.configurations.MailgunPropertiesConfig;

/**
 * A service for sending e-mails through the Mailgun API
 * @author Jacob
 */
@Service
public class MailService {
    //@Autowired private MailgunClient client;
    @Autowired private MailgunPropertiesConfig props;

//    public void sendEmail(String to, String subject, String text) {
//        this.client.sendEmail(URI.create(props.getMailgunUrl()), props.getMailgunFrom(), to, subject, text);
//    }
}
