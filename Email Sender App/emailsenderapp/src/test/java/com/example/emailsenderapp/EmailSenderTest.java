package com.example.emailsenderapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.emailsenderapp.services.EmailService;

@SpringBootTest
public class EmailSenderTest {
  @Autowired
  private EmailService emailService;

  @Test
  void emailSendTest() {
    System.out.println("sending EMail");
    emailService.sendEmail("ashutoshsahay12@gmail.com", "Email From SPring Boot", "This is for Testing");
  }

  @Test
  void sendHtmlInEmail() {
    String html = "" +
        "<h1 style='color:red; border:1px solid red;'>Welcome to Email Sender app</h1>"
        + "";
    emailService.sendEmail("ashutoshsahay12@gmail.com", "Email From SPring Boot", html);
  }

  @Test
  void sendEmailWithFile() {

    emailService.sendEmailWithFile("ashutoshsahay12@gmail.com", "Email with file", "This emial contain file",
        new File(
            "D:\\Study Related\\Projects java\\Email Sender App\\emailsenderapp\\src\\main\\resources\\static\\images\\profile.png"));
  }

  @Test
  void sendEmailWithFileWithStream() {
    File file = new File(
        "D:\\Study Related\\Projects java\\Email Sender App\\emailsenderapp\\src\\main\\resources\\static\\images\\profile.png");
    try {
      InputStream is = new FileInputStream(file);
      emailService.sendEmailWithFile("ashutoshsahay12@gmail.com", "Email with file", "This emial contain file",
          is);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
