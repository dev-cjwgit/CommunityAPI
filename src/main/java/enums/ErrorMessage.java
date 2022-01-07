package enums;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    UNDEFINED_EXCEPTION(0, "정의되지 않은 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    REQUEST_EXCEPTION(10, "", HttpStatus.BAD_REQUEST),
    LOGIN_NOT_EXIST_EMAIL(100, "서버에 존재하지 않는 이메일입니다.", HttpStatus.BAD_REQUEST),
    LOGIN_NOT_PASSWORD(101, "잘못된 비밀번호 입니다.", HttpStatus.BAD_REQUEST);
    Integer code;
    String errMsg;
    HttpStatus httpStatus;

    ErrorMessage(int code, String errMsg, HttpStatus httpStatus) {
        this.code = code;
        this.errMsg = errMsg;
        this.httpStatus = httpStatus;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
