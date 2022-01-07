package config;

import enums.ErrorMessage;
import exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Error> defaultException(Throwable e) {
        BaseException baseException = null;

        if (e instanceof BaseException) {
            baseException = (BaseException) e;
        }

        if (e instanceof MethodArgumentNotValidException) {
            baseException = new BaseException(ErrorMessage.VALIDATION_FAIL_EXCEPTION);

            //validation error message에서 본인이 domain에 작성한 default message만 가져오도록 하는
            List<ObjectError> messageList = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            String message = "";
            for (int i = 0; i < messageList.size(); i++) {
                String validationMessage = messageList.get(i).getDefaultMessage();
                message += "[" + validationMessage + "]";
            }
            baseException.setMsg(message);
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
