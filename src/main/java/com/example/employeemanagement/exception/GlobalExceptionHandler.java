package com.example.employeemanagement.exception;

import com.example.employeemanagement.controller.AccountController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;
    private final Logger log = LoggerFactory.getLogger(AccountController.class);


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
        Map<String, String> message = new HashMap<>();
        for(ObjectError error: ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError) error).getField();
            String errorMessage =  error.getDefaultMessage();
            message.put(fieldName,errorMessage);
        }
        log.error("Exception MethodArgumentNotValid: {}",message);

        ErrorResponse errorResponse = new ErrorResponse()
                .code("MethodArgumentNotValid")
                .status(400)
                .errorMessage(getMessage("MethodArgumentNotValid.message"))
                .errors(message)
                .detailMessage(ex.getLocalizedMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = getMessage("NoHandlerFoundException.message ") + ex.getHttpMethod() + " " + ex.getRequestURL();
        log.error("Exception NoHandlerFoundException: {}", message);

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
        String message = ex.getMethod() + " " +  getMessage("HttpRequestMethodNotSupported.message") + " ";
        for(HttpMethod httpMethod : ex.getSupportedHttpMethods()){
            message += httpMethod + " ";
        }
        ErrorResponse errorResponse = new ErrorResponse()
                .code("HttpRequestMethodNotSupported")
                .status(405)
                .errorMessage(message)
                .detailMessage(ex.getLocalizedMessage());
        return ResponseEntity.status(405).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = ex.getContentType() + " " + getMessage("HttpMediaTypeNotSupported.message");
        for(MediaType mediaType : ex.getSupportedMediaTypes()){
            message += mediaType + " ";
        }
        log.error("Exception HttpMediaTypeNotSupported: {}", message);
        ErrorResponse errorResponse = new ErrorResponse()
                .code("HttpMediaTypeNotSupported")
                .status(415)
                .errorMessage(message)
                .detailMessage(ex.getLocalizedMessage());
        return ResponseEntity.status(415).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = ex.getParameterName() + " " + getMessage("MissingServletRequestParameter.message");
        log.error("Exception MissingServletRequestParameter: {}", message);
        ErrorResponse errorResponse = new ErrorResponse()
                .code("MissingServletRequestParameter")
                .status(400)
                .errorMessage(message)
                .detailMessage(ex.getLocalizedMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        String message = ex.getName() + " " + getMessage("MethodArgumentTypeMismatchException.message") + " " +ex.getRequiredType().getName();
        log.error("Exception MethodArgumentTypeMismatchException: {}", message);

        ErrorResponse errorResponse = new ErrorResponse()
                .code("MethodArgumentTypeMismatchException")
                .status(400)
                .errorMessage(message)
                .detailMessage(ex.getLocalizedMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }



    @ExceptionHandler({CustomException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(
            Exception ex,
            WebRequest request){
        log.error("Exception NotFoundException: {}", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse()
                .code("account.not_found")
                .status(HttpStatus.NOT_FOUND.value())
                .errorMessage("Can not find account")
                .detailMessage(ex.getLocalizedMessage());
        System.out.println(errorResponse.toString());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
