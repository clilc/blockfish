package com.project.blockfish.businesslogic.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendMail(String to, String sub, String text);
}
