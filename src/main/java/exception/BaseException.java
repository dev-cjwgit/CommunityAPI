package exception;

import org.springframework.http.HttpStatus;

public interface BaseException {
    int getErrorCode();

    HttpStatus getHttpStatus();

    String getErrorMessage();
}
