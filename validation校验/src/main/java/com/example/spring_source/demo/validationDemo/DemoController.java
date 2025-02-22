package com.example.spring_source.demo.validationDemo;

import com.example.spring_source.demo.validationDemo.dto.BaseDto;
import com.example.spring_source.demo.validationDemo.group.CreateGroup;
import com.example.spring_source.demo.validationDemo.group.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Validated({UpdateGroup.class})
 * UpdateGroup 继承了Default
 * 所以@Validated({Default.class}) 也会被拦截
 *
 * 所以
 *两个写法就是等效
 *@Validated({Update.class})
 *@Validated({Update.class,Default.class})
 *
 */
@RestController
public class DemoController {

    @GetMapping("/update")
    public String update(@Validated({UpdateGroup.class}) BaseDto dto) {
        System.out.println(dto);
        return "ok";
    }

    @GetMapping("/create")
    public String create(@Validated({CreateGroup.class}) BaseDto dto) {
        System.out.println(dto);
        return "ok";
    }

}