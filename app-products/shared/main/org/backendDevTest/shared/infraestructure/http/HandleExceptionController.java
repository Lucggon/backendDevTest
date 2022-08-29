package org.backendDevTest.shared.infraestructure.http;

import org.backendDevTest.shared.domain.DomainError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandleExceptionController {
    @ExceptionHandler(value = {DomainError.class})
    public ResponseEntity<Map<String, String>> handleDomainException(DomainError ex){
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put(ex.getErrorCode(), ex.getErrorMsg());

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);

    }
}
