package config;

import exception.BaseException;
import exception.RequestInputException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Error> defaultException(Throwable e) {
        BaseException baseException = null;

        if (e instanceof BaseException) {
            baseException = ((RequestInputException) e).getBaseExceptionType();
        }
        return new ResponseEntity<>(Error.create(baseException), baseException.getHttpStatus());
    }


    @NoArgsConstructor
    @AllArgsConstructor
    static class Error {
        private int code;
        private HttpStatus status;
        private String message;

        static Error create(BaseException exception) {
            return new Error(exception.getErrorCode(), exception.getHttpStatus(), exception.getErrorMessage());
        }

        public int getCode() {
            return code;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
