package com.springboot;

import com.springboot.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.io.File;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private EmailSender emailSender;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws MessagingException {
        emailSender.sendEmail("Email Inline Attachment", "kulkarniabhijeet17@gmail.com",
                "kulkarniabhijeet17@gmail.com", true,
                new File("E:\\Abhijeet\\Pics\\IMG-20160124-WA0005.jpg"));
    }
}