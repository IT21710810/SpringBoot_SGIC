package org.example.samuelITMaven.advicerexception;

import org.example.samuelITMaven.exception.BadRequestException;
import org.example.samuelITMaven.exception.UnauthorizedException;
import org.example.samuelITMaven.util.StandardResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(ChangeSetPersister.NotFoundException e) {
        return new ResponseEntity<>(
                new StandardResponse(404, "Not Found", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardResponse> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(
                new StandardResponse(400, "Bad Request", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<StandardResponse> handleUnauthorizedException(UnauthorizedException e) {
        return new ResponseEntity<>(
                new StandardResponse(401, "Unauthorized", e.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(Exception.class) // Generic fallback
    public ResponseEntity<StandardResponse> handleGenericException(Exception e) {
        return new ResponseEntity<>(
                new StandardResponse(500, "Internal Server Error", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
