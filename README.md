# Email-Sender-API

A simple Spring Boot application for sending emails with file attachments.

## Features

- Send emails with attachments
- Simple and configurable

## Prerequisites

- Java 11 or higher
- Maven or Gradle
- An email server (SMTP)

## Configuration
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your email
spring.mail.password=your app generated password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## API Usage
- You can send a POST request to the (http://localhost:8080/api/v1/email/send-with-file) endpoint to send an email with an attachment.
- You can send a POST request to the (http://localhost:8080/api/v1/email/send) endpoint to send an email.
- (Refer Controller)

## Request Parameters
- to (string): The recipient's email address
- subject (string): The subject of the email
- message (string): The body of the email
- file (file): The file to be attached

## Example using Postman
- Set the HTTP method to POST.
- Set the URL to http://localhost:8080/sendEmailWithFile.
- In the Body tab, select form-data.
- Add the following fields:
- to: example@domain.com (Text)
- subject: Test Subject (Text)
- message: Test Message (Text)
- file: Select a file to upload (File)

## Thank You! For any improvement you may contact.

