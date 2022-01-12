package config;

import domain.dto.SlackDTO;
import enums.ErrorMessage;
import exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    SlackSender slackAPI;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Error> defaultException(Throwable e) {
        /**
         * Error Message 리팩토링 필요
         */
        BaseException baseException = null;

        if (e instanceof BaseException) {
            baseException = (BaseException) e;
        } else if (e instanceof MethodArgumentNotValidException) {
            baseException = new BaseException(ErrorMessage.VALIDATION_FAIL_EXCEPTION);

            //validation error message에서 본인이 domain에 작성한 default message만 가져오도록 하는
            List<ObjectError> messageList = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            for (int i = 0; i < messageList.size(); i++) {
                String validationMessage = messageList.get(i).getDefaultMessage();
                baseException.appendMsg(validationMessage);
            }
        } else if (e instanceof BindingException) {
            baseException = new BaseException(ErrorMessage.BINDING_FAIL_EXCEPTION);
            baseException.appendMsg(e.getCause().toString());
            for (StackTraceElement item : e.getStackTrace()) {
                baseException.appendTrace(item.toString());
            }
        } else {
            baseException = new BaseException(ErrorMessage.UNDEFINED_EXCEPTION);
            if (e.getCause() != null) {
                baseException.appendMsg(e.getCause().toString());
            }
            baseException.appendMsg(e.getMessage());
            for (StackTraceElement item : e.getStackTrace()) {
                baseException.appendTrace(item.toString());
            }
            slackAPI.send(new SlackDTO(baseException.getErrorMessage().toString() + "", baseException.getErrorTrace().toString(), ":ghost:"));
//            slackAPI.send(baseException);

        }

        return new ResponseEntity<>(Error.create(baseException), baseException.getHttpStatus());
    }


    @NoArgsConstructor
    @AllArgsConstructor
    static class Error {
        private int code;
        private HttpStatus status;
        private List<String> message;
        private List<String> trace;

        static Error create(BaseException exception) {
            return new Error(exception.getErrorCode(), exception.getHttpStatus(), exception.getErrorMessage(), exception.getErrorTrace());
        }

        public int getCode() {
            return code;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public List<String> getMessage() {
            return message;
        }

        public List<String> getTrace() {
            return trace;
        }
    }
}
