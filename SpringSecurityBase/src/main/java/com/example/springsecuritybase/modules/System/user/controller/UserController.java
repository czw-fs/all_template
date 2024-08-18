package com.example.springsecuritybase.modules.System.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springsecuritybase.modules.System.user.model.dto.CreateUserDto;
import com.example.springsecuritybase.modules.System.user.model.dto.UpdateUserDto;
import com.example.springsecuritybase.modules.System.user.model.dto.UserSearchDto;
import com.example.springsecuritybase.modules.System.user.model.vo.UserVo;
import com.example.springsecuritybase.modules.System.user.service.UserService;
import com.example.springsecuritybase.modules.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
    public Result<Void> createUser(@RequestBody CreateUserDto userDto) {
        userService.createUser(userDto);
        return Result.success();
    }

    /**
     * 修改用户
     * @param userDto
     * @return
     */
    @PutMapping("/update")
    public Result<Void> updateUser(@RequestBody UpdateUserDto userDto) {
        userService.updateUser(userDto);
        return Result.success();
    }

    /**
     * 根据id查询用户
     */
    @GetMapping("/{id}")
    public Result<UserVo> getById(@PathVariable Long id) {
        UserVo userVo = userService.getOneById(id);
        return Result.success(userVo);
    }

    /**
     * 根据id删除用户
     */
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        userService.removeById(id);
        return Result.success();
    }



    /**
     * 分页查询用户
     * @param userDto
     * @return
     */
    @GetMapping("/page")
    public Result<Page<UserVo>> page(@Validated UserSearchDto userDto) {
        Page<UserVo> userDtoPage = userService.selectPage(userDto);
        return Result.success(userDtoPage);
    }
}
