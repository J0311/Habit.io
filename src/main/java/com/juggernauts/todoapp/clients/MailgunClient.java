//package com.juggernauts.todoapp.clients;
//
//import java.net.URI;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.juggernauts.todoapp.configurations.MailgunConfig;
//import com.juggernauts.todoapp.models.MailgunResponse;
//
///**
// * The client and configurations for the Mailgun API service
// * @author Jacob

// */
//@FeignClient(contextId="mailgunClient", name="mailService", url="http://meow.com", configuration=MailgunConfig.class)
//public interface MailgunClient {
//    /**
//     * Makes a POST request to the /messages endpoint of the Mailgun API service
//     * @param from The sender of the email
//     * @param to To whom the email is being sent
//     * @param subject The subject of the email
//     * @param text The text body of the email
//     * @return A MailgunResponse object showing the ID and status of the email
//     */

//    @PostMapping("/messages")
//    void sendEmail(URI baseUrl, @RequestParam String from, @RequestParam String to, @RequestParam String subject, @RequestParam String text);
//}
