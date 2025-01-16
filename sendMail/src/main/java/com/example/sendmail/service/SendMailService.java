package com.example.sendmail.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMailService {
    private final MailProperties mailProperties;
    private final JavaMailSender javaMailSender;


    public void sendTextEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.getUsername());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendHtmlEmail(String to, String subject, String htmlText) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);  // 第三个参数表示是否开启多附件支持
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlText, true);  // 第一个参数为邮件内容，第二个参数为true表示HTML格式
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("异常，异常信息：{}",e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


    // 发送带附件的邮件
    public void sendMailWithAttachments(String to, String subject, String content, File[] attachments) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);  // 第三个参数表示是否开启多附件支持

            helper.setFrom(mailProperties.getUsername());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);  // 第二个参数为true表示HTML格式的邮件

            if (attachments != null) {
                for (File attachment : attachments) {
                    helper.addAttachment(attachment.getName(), attachment);
                }
            }

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("异常，异常信息：{}",e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
