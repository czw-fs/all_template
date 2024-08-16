package com.example.springsecuritybase.modules.test.TestController;

import com.example.springsecuritybase.modules.common.model.Result;
import com.example.springsecuritybase.modules.test.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用
 */

@RestController
@RequiredArgsConstructor
public class DemoController {


    private final TestMapper testMapper;

    @GetMapping("/fs")
    public Result<Object> login(){



        return Result.success( testMapper.selectById(1));
    }
}
