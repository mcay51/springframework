package tr.com.mcay.errorcodesimulation.exceptions;

import org.springframework.http.HttpStatus;

public class ClientErrorException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public ClientErrorException(HttpStatus status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }
} 