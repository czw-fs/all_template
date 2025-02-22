package com.example.shiro_test.model.param;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.List;

@Data
public class MailParam {

    @NotEmpty(message = "接收方邮箱不能为空")
    private List<@Email(message = "接收方邮箱格式不正确") String> to; // 接收方
    private List<@Email(message = "抄送人邮箱格式不正确") String> cc; //抄送人
    private String[] bcc; //邮件会同时发送给密送列表中的人，但其他收件人看不到这些密送地址。

    private String subject; //邮件主题，概述邮件内容。
    private String text; //邮件内容

    private List<File> attachments; //附件
}