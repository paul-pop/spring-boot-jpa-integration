package com.andigital.api.controller;

import com.andigital.api.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Spring controller advice used for exception handling.
 *
 * Created by Paul Pop on 27/10/2015.
 */
@ControllerAdvice
class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(status.value(), status.getReasonPhrase());
        return new ResponseEntity<>(errorResponse, status);
    }
}
