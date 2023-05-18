package com.az.mykowel.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(
        String toMail,
        String subject,
        String body
    ){
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom("my.kowel.help.center@gmail.com");
            message.setTo(toMail);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);

            System.out.println("Message sent!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}