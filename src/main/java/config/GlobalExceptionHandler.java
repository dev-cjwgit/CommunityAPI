package config;

import enums.ErrorMessage;
import exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import java.io.IOException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<BaseException> defaultException(Throwable e, HandlerMethod handlerMethod) {
        BaseException baseException = null;

        if (e instanceof MethodArgumentNotValidException) {
            baseException = new BaseException(e.getClass().getSimpleName(), ErrorMessage.UNDEFINED_EXCEPTION);

            //validation error message에서 본인이 domain에 작성한 default message만 가져오도록 하는
            List<ObjectError> messageList = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            String message = "";
            for (int i = 0; i < messageList.size(); i++) {
                String validationMessage = messageList.get(i).getDefaultMessage();
                message += "[" + validationMessage + "]";
            }
            baseException.setErrorMessage(message);
        }
        return new ResponseEntity<>(baseException, baseException.getHttpStatus());

    }
}
