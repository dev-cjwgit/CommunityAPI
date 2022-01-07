package exception;

import enums.ErrorMessage;
import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    private int code;
    private String msg;
    private HttpStatus httpStatus;

    public BaseException(ErrorMessage errorMessage) {
        this.code = errorMessage.getErrorCode();
        this.msg = errorMessage.getErrorMessage();
        this.httpStatus = errorMessage.getHttpStatus();
    }

    public int getErrorCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
