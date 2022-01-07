package exception;

import org.springframework.http.HttpStatus;

public class RequestInputException extends RuntimeException implements BaseException {

    private BaseException baseExceptionType;

    public RequestInputException(BaseException baseExceptionType) {
        super(baseExceptionType.getErrorMessage());
        this.baseExceptionType = baseExceptionType;
    }

    public BaseException getBaseExceptionType() {
        return baseExceptionType;
    }

    @Override
    public int getErrorCode() {
        return baseExceptionType.getErrorCode();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return baseExceptionType.getHttpStatus();
    }

    @Override
    public String getErrorMessage() {
        return baseExceptionType.getErrorMessage();
    }
}
