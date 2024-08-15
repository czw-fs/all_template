package com.example.springsecuritybase.modules.System.convert;

import com.example.springsecuritybase.modules.System.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.model.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConvert {

    User UserDtoToUser(UserDto userDto);
}
