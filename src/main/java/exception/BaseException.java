package exception;

import enums.ErrorMessage;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BaseException extends RuntimeException {
    protected String className;
    protected String errorMessage;
    protected Integer code;
    protected HttpStatus httpStatus;


    public BaseException(ErrorMessage errorMessage) {
        this(null, errorMessage);
    }

    public BaseException(String className, ErrorMessage errorMessage) {
        this.className = className != null ? className : this.getClass().getSimpleName();
        this.errorMessage = errorMessage.getErrMsg();
        this.code = errorMessage.getCode();
        this.httpStatus = errorMessage.getHttpStatus();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
