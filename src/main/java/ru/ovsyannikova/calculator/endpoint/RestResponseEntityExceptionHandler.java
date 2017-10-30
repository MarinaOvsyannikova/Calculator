package ru.ovsyannikova.calculator.endpoint;

import io.swagger.annotations.ApiOperation;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ApiOperation(value = "Response for unknown operation", response = ResponseEntity.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unknown operation")
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> handleNullPointer(Exception ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ApiOperation(value = "Response for wrong format of expression", response = ResponseEntity.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong format of expression")
    @ExceptionHandler(value = ParseCancellationException.class)
    public ResponseEntity<Object> handleParseCancellationException(Exception ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ApiOperation(value = "Response for wrong format of date", response = ResponseEntity.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong format of date")
    @ExceptionHandler(value = ParseException.class)
    public ResponseEntity<Object> handleParseException(Exception ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
