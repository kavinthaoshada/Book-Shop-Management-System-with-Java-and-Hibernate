package com.calm.webdb.util;

import com.calm.webdb.controller.EmailController;
import com.calm.webdb.service.EmailService;

public class MailTest {
    public static void main(String[] args) {
        // Initialize EmailService
        EmailService emailService = new EmailService();

        // Create an instance of EmailController with EmailService
        EmailController emailController = new EmailController(emailService);

        // Use the EmailController to send an email
        emailController.sendEmail("kavinthaoshada@gmail.com", "Test Subject", "Test Content");
//        emailController.sendEmail("recipient@example.com", "Test Subject", "Test Content");
    }
}
