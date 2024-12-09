package com.polyticstudios.mycircle.authservice.mappers;

import com.polyticstudios.mycircle.authservice.dtos.UserDto;
import com.polyticstudios.mycircle.authservice.entities.AppUser;

public class UserDtoMapper {
    public static AppUser mapUserDtoToUser(UserDto userDto, AppUser user) {
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
