package com.example.springsecuritybase.modules.System.user.convert;


import com.example.springsecuritybase.modules.System.user.model.dto.CreateUserDto;
import com.example.springsecuritybase.modules.System.user.model.dto.UpdateUserDto;
import com.example.springsecuritybase.modules.System.user.model.entities.User;
import com.example.springsecuritybase.modules.System.user.model.vo.UserVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserConvert {

    @InheritConfiguration
    User CreateUserDtoToEntity(CreateUserDto userDto);

    @InheritConfiguration
    User updateUserDtoToEntity(UpdateUserDto userDto);

    @InheritConfiguration
    UserVo entityToUserVo(User user);


    List<UserVo> userListToUserVoList(List<User> records);
}
