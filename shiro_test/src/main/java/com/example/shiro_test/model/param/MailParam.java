package com.example.shiro_test.model.param;

import com.example.shiro_test.annotation.valid.email.ValidEmailList;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.util.List;

@Data
public class MailParam {

    /**
     * 接收方
     */
    @ValidEmailList(message = "接收方邮箱不能为空或接收方邮箱格式不正确")
    private List<String> to;

    /**
     * 邮件主题，概述邮件内容。
     */
    @NotBlank(message = "邮件主题不能为空")
    private String subject;
    /**
     * 邮件内容
     */
    @NotBlank(message = "邮件内容不能为空")
    private String text;

    /**
     * 抄送人
     */
    private List<@Email(message = "抄送人邮箱格式不正确") String> cc;

    /**
     * 密送人
     * 邮件会同时发送给密送列表中的人，但其他收件人看不到这些密送地址
     */
    private String[] bcc;

    /**
     * 附件
     */
    private List<File> attachments;
}