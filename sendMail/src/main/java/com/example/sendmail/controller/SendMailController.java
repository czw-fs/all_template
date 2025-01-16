package com.example.sendmail.controller;

import com.example.sendmail.service.SendMailService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 必须启用 @EnableAsync再配置类上
 */
@RestController
@RequiredArgsConstructor
public class SendMailController {

    private final SendMailService sendMailService;

    @GetMapping("/sendTextMail")
    public void sendTextMail() {
        sendMailService.sendTextEmail("chenziwen0413@163.com","测试主题","测试内容");
    }

    @GetMapping("/sendHtmlMail")
    public void sendHtmlMail() {
        String content = "<h1>This is an HTML Email</h1><p>This email contains HTML content</p>";
        String subject = "测试HtmlMail";
        String to = "chenziwen0413@163.com";
        sendMailService.sendHtmlEmail(to, subject, content);
    }
}
