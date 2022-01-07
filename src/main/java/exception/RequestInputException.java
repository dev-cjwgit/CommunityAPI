package exception;

import enums.ErrorMessage;

public class RequestInputException extends BaseException {

    public RequestInputException(ErrorMessage errorMessage) {
        super(null, errorMessage);
    }
}
