package com.example.springsecuritybase.modules.System.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springsecuritybase.modules.System.user.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.user.service.UserService;
import com.example.springsecuritybase.modules.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 新增用户
     * @param userDto
     * @return
     */
    @PostMapping("/create")
    public Result<Void> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return Result.success();
    }

    /**
     * 修改用户
     * @param userDto
     * @return
     */
    @PutMapping("/update")
    public Result<Void> updateUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return Result.success();
    }

    /**
     * 分页查询用户
     * @param userDto
     * @return
     */
    @PutMapping("/page")
    public Result<Page<UserDto>> page(@RequestBody UserDto userDto) {
        Page<UserDto> userDtoPage = userService.selectPage(userDto);
        return Result.success(userDtoPage);
    }

    /**
     * 根据id查询用户
     * @param userDto
     * @return
     */
    @@GetMapping("/{id}")
    public Result<Void> getById(@RequestBody UserDto userDto) {

        return Result.success();
    }

    /**
     * 根据id删除用户
     * @param userDto
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<Void> delete(@RequestBody UserDto userDto) {

        return Result.success();
    }
}
