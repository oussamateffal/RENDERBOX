package com.renderbox.renderboxporoject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationEmail(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Email address verification");
        message.setText("Cliquez sur le lien suivant pour vérifier votre adresse e-mail: http://votre-site.com/verify?token=" + token);
        javaMailSender.send(message);
    }
}
