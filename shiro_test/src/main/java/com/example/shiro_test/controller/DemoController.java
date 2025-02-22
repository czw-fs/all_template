package com.example.shiro_test.controller;

import com.example.shiro_test.model.Result;
import com.example.shiro_test.model.param.MailParam;
import com.example.shiro_test.service.SendMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final SendMailService sendMailService;

    @PostMapping("/testMail")
    public Result<Void> fs(@RequestBody @Validated MailParam mailParam) {
        return sendMailService.sendTextEmail(mailParam);
    }
}
