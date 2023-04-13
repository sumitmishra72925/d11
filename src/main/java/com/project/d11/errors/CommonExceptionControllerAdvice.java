/*
 * Copyright Cashfree(c) 2019.
 */

package com.project.d11.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

@RestControllerAdvice
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class CommonExceptionControllerAdvice {

    public static final String REQUEST_INVALID = "REQUEST_INVALID";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse onInvalidRequest(MethodArgumentNotValidException e) {
        log.error(e.toString(), e);
        return ErrorResponse.builder().message(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage()).status(HttpStatus.BAD_REQUEST.value()).build();
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse onInvalidRequest(WebExchangeBindException e) {
        log.error(e.toString(), e);
        return ErrorResponse.builder().message(e.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST.value()).build();
    }



    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse onNoEndpointFound(ResponseStatusException e) {
        log.info(e.toString());
        return ErrorResponse.builder().message("Couldn't find the resource").status(HttpStatus.NOT_FOUND.value()).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse onHttpRequestUnreadable(HttpMessageNotReadableException e) {
        log.info(e.toString());
        return ErrorResponse.builder().message(e.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST.value()).build();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse onUnknownRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ErrorResponse.builder().message("Internal Server Error!").status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }

        @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse onUnknownException(Exception e) {
        log.error(e.toString(), e);
            return ErrorResponse.builder().message("Internal Server Error!").status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse onEntityNotFoundException(EntityNotFoundException e) {
        log.error(e.toString(), e);
        return ErrorResponse.builder().message(e.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST.value()).build();
    }



    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse onValidationException(ValidationException e) {
        log.error(e.toString(), e);
        return ErrorResponse.builder().message(e.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST.value()).build();
    }

}
