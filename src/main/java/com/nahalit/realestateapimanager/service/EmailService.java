package com.nahalit.realestateapimanager.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  private final JavaMailSender javaMailSender;

  public EmailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  public void sendEmail(String[] sendTo, String[] sendCC, String[] sendBcc, String mailSubject, String messageBody) throws MailException {
    SimpleMailMessage mailMessage = new SimpleMailMessage();

    mailMessage.setTo(sendTo);
    mailMessage.setFrom("Badrul");
    mailMessage.setCc(sendCC);
    mailMessage.setBcc(sendBcc);
    mailMessage.setSubject(mailSubject);
    mailMessage.setText(messageBody);

    javaMailSender.send(mailMessage);

  }
}
