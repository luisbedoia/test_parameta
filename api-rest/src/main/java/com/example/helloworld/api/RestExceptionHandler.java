package com.example.helloworld.api;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.soap.client.SoapFaultClientException;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
  public ResponseEntity<Map<String, Object>> handleBindingExceptions(Exception ex) {
    Map<String, String> errors;
    if (ex instanceof MethodArgumentNotValidException manve) {
      errors =
          manve.getBindingResult().getFieldErrors().stream()
              .collect(
                  Collectors.toMap(
                      FieldError::getField,
                      FieldError::getDefaultMessage,
                      (first, second) -> first,
                      LinkedHashMap::new));
    } else if (ex instanceof BindException bindException) {
      errors =
          bindException.getBindingResult().getFieldErrors().stream()
              .collect(
                  Collectors.toMap(
                      FieldError::getField,
                      FieldError::getDefaultMessage,
                      (first, second) -> first,
                      LinkedHashMap::new));
    } else {
      errors = Map.of("error", "Unknown validation error");
    }

    return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation errors were found", errors);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Map<String, Object>> handleConstraintViolation(
      ConstraintViolationException ex) {
    Map<String, String> errors =
        ex.getConstraintViolations().stream()
            .collect(
                Collectors.toMap(
                    violation -> violation.getPropertyPath().toString(),
                    ConstraintViolation::getMessage,
                    (first, second) -> first,
                    LinkedHashMap::new));
    return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation errors were found", errors);
  }

  @ExceptionHandler({
    SoapFaultClientException.class,
    WebServiceIOException.class,
    IllegalStateException.class
  })
  public ResponseEntity<Map<String, Object>> handleSoapErrors(Exception ex) {
    return buildErrorResponse(
        HttpStatus.BAD_GATEWAY,
        "Unable to reach the SOAP service",
        Map.of("detail", ex.getMessage() == null ? "Unknown error" : ex.getMessage()));
  }

  private ResponseEntity<Map<String, Object>> buildErrorResponse(
      HttpStatus status, String message, Map<String, String> errors) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", OffsetDateTime.now().toString());
    body.put("status", status.value());
    body.put("error", message);
    body.put("details", errors);
    return ResponseEntity.status(status).body(body);
  }
}
