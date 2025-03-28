package tr.com.mcay.errorcodesimulation.exceptions;

import org.springframework.http.HttpStatus;

public class ServerErrorException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public ServerErrorException(HttpStatus status, String errorCode, String message) {
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