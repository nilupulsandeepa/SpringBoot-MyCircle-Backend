package com.polyticstudios.mycircle.authservice.exceptions;

import com.polyticstudios.mycircle.authservice.constants.AuthConstants;
import com.polyticstudios.mycircle.authservice.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleUserAlreadyExistsException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorDto(AuthConstants.ERROR_CONFLICT, AuthConstants.MESSAGE_CONFLICT));
    }
}
