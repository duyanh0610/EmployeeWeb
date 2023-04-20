package com.example.employeemanagement.exception;

import com.example.employeemanagement.exception.errors.DepartmentNotFoundException;
import com.example.employeemanagement.exception.errors.ErrorResponse;
import com.example.employeemanagement.exception.errors.UserNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private String getMessage(String key){
        return messageSource.getMessage(key, null, "Default Message", LocaleContextHolder.getLocale());
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for(ObjectError error: ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError) error).getField();
            String errorMessage =  error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        }
        return new ResponseEntity<>(errors,status);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = getMessage("NoHandlerFoundException.message") + ex.getHttpMethod() + " " + ex.getRequestURL();
        ErrorResponse errorResponse = new ErrorResponse()
                .code("NoHandlerFound")
                .status(404)
                .errorMessage(message)
                .detailMessage(ex.getLocalizedMessage());
        System.out.println("abc  " + errorResponse.toString());
        return ResponseEntity.status(404).body(errorResponse);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }




    @ExceptionHandler({UserNotFoundException.class, DepartmentNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(
            Exception ex,
            WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse()
                .code("account.not_found")
                .status(HttpStatus.NOT_FOUND.value())
                .errorMessage("Can not find account")
                .detailMessage(ex.getLocalizedMessage());
        System.out.println(errorResponse.toString());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
