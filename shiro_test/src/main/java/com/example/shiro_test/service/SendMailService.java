package com.example.shiro_test.service;


import com.example.shiro_test.model.Result;
import com.example.shiro_test.model.param.MailParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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


    public Result<Void> sendTextEmail(MailParam mailParam) {
        SimpleMailMessage message = new SimpleMailMessage();

        //发送人
        message.setFrom(mailProperties.getUsername());
        //接收人
        message.setTo(mailParam.getTo().toArray(new String[0]));
        //抄送人
        if(CollectionUtils.isNotEmpty(mailParam.getCc())) {
            message.setCc(mailParam.getCc().toArray(new String[0]));
        }

        message.setSubject(mailParam.getSubject());
        message.setText(mailParam.getText());

        javaMailSender.send(message);
        return Result.success("邮箱发送成功");
    }

    // 发送带附件的html邮件
    public Result<Void> sendHtmlEmail(MailParam mailParam) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);  // 第三个参数表示是否开启多附件支持
            //发送人
            helper.setFrom(mailProperties.getUsername());
            //接收人
            helper.setTo(mailParam.getTo().toArray(new String[0]));
            //抄送人
            if(CollectionUtils.isNotEmpty(mailParam.getCc())) {
                helper.setCc(mailParam.getCc().toArray(new String[0]));
            }

            helper.setSubject(mailParam.getSubject());
            helper.setText(mailParam.getText(), true);  // 第一个参数为邮件内容，第二个参数为true表示HTML格式

            if (CollectionUtils.isNotEmpty(mailParam.getAttachments())) {
                for (File attachment : mailParam.getAttachments()) {
                    helper.addAttachment(attachment.getName(), attachment);
                }
            }

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("sendHtmlEmail发送邮件异常，异常，参数：{}，异常信息：{}",mailParam,e.getMessage(), e);
        }
        return Result.success("邮箱发送成功");
    }
}
