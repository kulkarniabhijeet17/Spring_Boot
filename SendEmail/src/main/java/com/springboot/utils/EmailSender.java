package com.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailSender {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(final String subject, final String fromEmailAddress,
                          final String toEmailAddresses, final boolean isHtmlMail, final File attachment) throws MessagingException {
        // Sending simple emails
        /*SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@gmail.com");
        simpleMailMessage.setTo("kulkarniabhijeet17@gmail.com");
        simpleMailMessage.setSubject("Spring Core Document");
        simpleMailMessage.setText("Good morning!");

        mailSender.send(simpleMailMessage);*/

        // Sending emails with attachments
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(fromEmailAddress);
        helper.setTo(toEmailAddresses);
        helper.setSubject(subject);

        if (isHtmlMail) {
            helper.setText("<html><body>" + "<h1>Email Inline Attachment using MimeMessageHelper</h1>" + "<img src=\"cid:IMG-20160124-WA0005.jpg\">" + "</html></body>", true);
        } else {
            helper.setText("Email Inline Attachment using MimeMessageHelper");
        }

        FileSystemResource fileSystemResource = new FileSystemResource(attachment);
        // helper.addAttachment("Invoice", fileSystemResource);
        // helper.addInline(attachment.getName(), new ClassPathResource("E:\Abhijeet\Pics\IMG-20160124-WA0005.jpg"));
        helper.addInline(attachment.getName(), fileSystemResource);

        mailSender.send(mimeMessage);
        System.out.println("Email sending complete.");
    }
}