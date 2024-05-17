package com.virith.storerentalmanagementsystems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDTO {
    private String message;
    private int statusCode;
    private LocalDateTime errorTime;
    private String errorPath;
}
