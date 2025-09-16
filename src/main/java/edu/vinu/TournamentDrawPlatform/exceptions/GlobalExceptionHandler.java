package edu.vinu.TournamentDrawPlatform.exceptions;

import edu.vinu.TournamentDrawPlatform.exceptions.custom.InternalServerErrorException;
import edu.vinu.TournamentDrawPlatform.exceptions.custom.NotFoundException;
import edu.vinu.TournamentDrawPlatform.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ApiResponse> handleInternalServerErrorException(InternalServerErrorException ex) {
        return ResponseEntity.status(500).body(new ApiResponse(ex.getMessage(), null));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(500).body(new ApiResponse(ex.getMessage(), null));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> NotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(new ApiResponse(ex.getMessage(), null));
    }
}
