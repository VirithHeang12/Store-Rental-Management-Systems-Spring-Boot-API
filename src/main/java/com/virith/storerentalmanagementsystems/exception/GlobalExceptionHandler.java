package com.virith.storerentalmanagementsystems.exception;

import com.virith.storerentalmanagementsystems.dto.ErrorResponseDTO;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(ex.getMessage(), HttpStatus.BAD_GATEWAY.value(), LocalDateTime.now(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(ex.getMessage() + "handled", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(Exception ex, WebRequest request){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponseDTO);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponseDTO);
    }
}
