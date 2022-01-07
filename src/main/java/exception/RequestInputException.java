package exception;

import enums.ErrorMessage;

public class RequestInputException extends BaseException {

    public RequestInputException(ErrorMessage baseExceptionType) {
        super(baseExceptionType);
    }

}
