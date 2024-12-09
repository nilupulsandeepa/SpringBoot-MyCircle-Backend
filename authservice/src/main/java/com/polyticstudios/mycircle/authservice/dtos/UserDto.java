package com.polyticstudios.mycircle.authservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserDto {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
