package com.example.springsecuritybase.modules.System.user.convert;


import com.example.springsecuritybase.modules.System.user.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.user.model.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConvert {

    User UserDtoToUser(UserDto userDto);
}
