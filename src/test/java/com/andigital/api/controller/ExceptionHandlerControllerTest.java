package com.andigital.api.controller;

import com.andigital.api.model.ErrorResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link ExceptionHandlerController}
 *
 * Created by Paul Pop on 27/10/2015.
 */
public class ExceptionHandlerControllerTest {

    private ExceptionHandlerController controller;

    @Before
    public void before() {
        controller = new ExceptionHandlerController();
    }

    @Test
     public void handleBadRequestException() {
        ErrorResponse errorResponse = new ErrorResponse(400, "Bad Request");

        ResponseEntity<Object> result = controller.handleExceptionInternal(null, null, null, HttpStatus.BAD_REQUEST, null);

        assertEquals(result.getBody(), errorResponse);
    }

    @Test
    public void handleInternalErrorException() {
        ErrorResponse errorResponse = new ErrorResponse(500, "Internal Server Error");

        ResponseEntity<Object> result = controller.handleExceptionInternal(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, null);

        assertEquals(result.getBody(), errorResponse);
    }

}
