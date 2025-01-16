package com.example.sendmail.model.request;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
public class MailReq {

    private String from; //发送方,要和配置文件中的一致
    private String replyTo; // 接收方的回复邮箱地址，一般和发送方一致
    private String[] to; // 接收方
    private String[] cc; //抄送人
    private String[] bcc; //邮件会同时发送给密送列表中的人，但其他收件人看不到这些密送地址。
    private Date sentDate; //邮件的发送日期
    private String subject; //邮件主题，概述邮件内容。
    private String text; //邮件内容
}
