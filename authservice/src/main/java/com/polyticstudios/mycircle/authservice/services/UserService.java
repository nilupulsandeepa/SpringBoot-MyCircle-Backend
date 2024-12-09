package com.polyticstudios.mycircle.authservice.services;

import com.polyticstudios.mycircle.authservice.dtos.UserDto;
import com.polyticstudios.mycircle.authservice.entities.AppUser;
import com.polyticstudios.mycircle.authservice.exceptions.UserAlreadyExistsException;
import com.polyticstudios.mycircle.authservice.mappers.UserDtoMapper;
import com.polyticstudios.mycircle.authservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    //---- User Registration
    public void registerUser(UserDto userDto) {
        Optional<AppUser> user = userRepository.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException();
        }
        AppUser newUser = UserDtoMapper.mapUserDtoToUser(userDto, new AppUser());
        userRepository.save(newUser);
    }
}