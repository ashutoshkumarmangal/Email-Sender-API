package com.example.emailsenderapp.services.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.emailsenderapp.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.*;
// import com.avin.EmailSenderApp.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

  private JavaMailSender mailSender;

  public EmailServiceImpl(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

  @Override
  public void sendEmail(String to, String subject, String message) {
    // TODO Auto-generated method stub
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(to);
    simpleMailMessage.setSubject(subject);
    simpleMailMessage.setText(message);
    simpleMailMessage.setFrom("aashuakm12@gmail.com");
    mailSender.send(simpleMailMessage);
    logger.info("Email has been sent");
  }

  @Override
  public void sendEmail(String[] to, String subject, String message) {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(to);
    simpleMailMessage.setSubject(subject);
    simpleMailMessage.setText(message);
    simpleMailMessage.setFrom("aashuakm12@gmail.com");
    mailSender.send(simpleMailMessage);
  }

  @Override
  public void sendEmailWithFile(String to, String subject, String message, File file) {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
      helper.setTo(to);
      helper.setText(message);
      helper.setSubject(subject);
      helper.setFrom("aashuakm12@gmail.com");
      FileSystemResource fileSystemResource = new FileSystemResource(file);
      helper.addAttachment(fileSystemResource.getFilename(), file);
      mailSender.send(mimeMessage);
      logger.info("Email send success");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public void sendEmailWithHtml(String to, String subject, String htmlContent) {
    MimeMessage simpleMailMessage = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage, true, "UTF-8");
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setFrom("aashuakm12@gmail.com");
      helper.setText(htmlContent, true);
      mailSender.send(simpleMailMessage);
      logger.info("Email has been sent");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void sendEmailWithFile(String to, String subject, String message, InputStream ins) {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
      helper.setTo(to);
      helper.setText(message, true);
      helper.setSubject(subject);
      // helper.setFrom("aashuakm12@gmail.com");
      File file = new File(
          "D:\\Study Related\\Projects java\\Email Sender App\\emailsenderapp\\src\\main\\resources\\static\\images\\test.png");
      Files.copy(ins, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      FileSystemResource fileSystemResource = new FileSystemResource(file);
      helper.addAttachment(fileSystemResource.getFilename(), file);
      mailSender.send(mimeMessage);
      logger.info("Email send success");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
