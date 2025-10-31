package dev.matheuslf.desafio.inscritos.config;

import dev.matheuslf.desafio.inscritos.exception.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleEnumError(HttpMessageNotReadableException ex) {
        Map<String, String> error = Map.of(
                "status", "Valor inválido."
        ); //melhorar mensagem de erro
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Map<String, String>> handTaskNotFoundException(TaskNotFoundException ex) {
        Map<String, String> error = Map.of(
                "status", ex.getMessage()
        );
        return ResponseEntity.badRequest().body(error);
    }

}
