package com.example.shiro_test.controller;

import com.example.shiro_test.model.Result;
import com.example.shiro_test.service.SendMailService;
import com.example.shiro_test.service.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VerificationCodeController {
    private final VerificationCodeService verificationCodeService;
    private final SendMailService sendMailService;

    @GetMapping("/getVerificationCode")
    public Result<Void> getVerificationCode(String email) {
        return sendMailService.sendVerificationCodeEmail(email);
    }
}
