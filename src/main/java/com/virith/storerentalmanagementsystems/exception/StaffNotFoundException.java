package com.virith.storerentalmanagementsystems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StaffNotFoundException extends ResourceNotFoundException {
    public StaffNotFoundException(String fieldName, String fieldValue) {
        super("Staff", fieldName, fieldValue);
    }
}
