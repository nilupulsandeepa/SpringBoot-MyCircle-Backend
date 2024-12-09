package com.polyticstudios.mycircle.authservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ErrorDto {
    public String error;
    public String message;
}
