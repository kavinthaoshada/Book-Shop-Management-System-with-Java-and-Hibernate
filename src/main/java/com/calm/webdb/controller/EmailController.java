package com.calm.webdb.controller;

import com.calm.webdb.service.EmailService;

public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    public String sendEmail(String to, String subject, String content) {
        emailService.sendEmail(to, subject, content);

        // Handle response or redirect
        return "redirect:/success"; // or return a success page
    }
}

