package com.example.employeemanagement.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {
    private final MessageSource messageSource;

    public AuthExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private String getMessage(String key){
        return messageSource.getMessage(key, null, "Default Message", LocaleContextHolder.getLocale());
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String message = getMessage("AuthenticationException.message");

        ErrorResponse errorResponse = new ErrorResponse()
                .errorMessage(message)
                .detailMessage(authException.getLocalizedMessage())
                .code("AuthenticationException")
                .status(401)
                .timeStamp(LocalDateTime.now().toString());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(errorResponse);
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(json);

    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String message = getMessage("AuthorizationException.message");

        ErrorResponse errorResponse = new ErrorResponse()
                .errorMessage(message)
                .detailMessage(accessDeniedException.getLocalizedMessage())
                .code("AuthorizationException")
                .status(403)
                .timeStamp(LocalDateTime.now().toString());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(errorResponse);
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(json);
    }
}
