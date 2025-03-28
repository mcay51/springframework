package tr.com.mcay.errorcodesimulation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import tr.com.mcay.errorcodesimulation.exceptions.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleClientErrorException(ClientErrorException ex, WebRequest request) {
         System.out.println("GlobalExceptionHandler.handleGlobalException:ex "+ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatus().value(),
                ex.getErrorCode(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleServerErrorException(ServerErrorException ex, WebRequest request) {
        System.out.println("GlobalExceptionHandler.handleServerErrorException:ex "+ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatus().value(),
                ex.getErrorCode(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(InformationException.class)
    public ResponseEntity<ErrorResponse> handleInformationException(InformationException ex, WebRequest request) {
        System.out.println("GlobalExceptionHandler.handleInformationException:ex "+ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatus().value(),
                ex.getErrorCode(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(RedirectException.class)
    public ResponseEntity<ErrorResponse> handleRedirectException(RedirectException ex, WebRequest request) {
        System.out.println("GlobalExceptionHandler.handleRedirectException:ex "+ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatus().value(),
                ex.getErrorCode(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        System.out.println("GlobalExceptionHandler.handleGlobalException:ex "+ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

