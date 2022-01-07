package enums;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    VALIDATION_FAIL_EXCEPTION(-1, "입력 값의 조건이 잘못 되었습니다.", HttpStatus.BAD_REQUEST),
    UNDEFINED_EXCEPTION(0, "정의되지 않은 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    BINDING_FAIL_EXCEPTION(1, "내부 서버에서 오류가 발생하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    REQUEST_EXCEPTION(10, "", HttpStatus.BAD_REQUEST),
    LOGIN_NOT_EXIST_EMAIL(100, "서버에 존재하지 않는 이메일입니다.", HttpStatus.BAD_REQUEST),
    LOGIN_NOT_PASSWORD(101, "잘못된 비밀번호 입니다.", HttpStatus.BAD_REQUEST),
    ACCESS_TOKEN_EXPIRE(1000, "토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    ACCESS_TOKEN_NOT_LOAD(1001, "토큰을 불러오지 못하였습니다.", HttpStatus.UNAUTHORIZED),
    ACCESS_TOKEN_INVALID_HEADER(1010, "토큰 해더가 손상되었습니다.", HttpStatus.UNAUTHORIZED),
    ACCESS_TOKEN_INVALID_PAYLOADS(1011, "토큰 정보가 손상되었습니다.", HttpStatus.UNAUTHORIZED),
    ACCESS_TOKEN_INVALID_SIGNATURE(1012, "토큰이 유효하지 않습니다.", HttpStatus.UNAUTHORIZED),
    ACCESS_TOKEN_EMPTY(1013, "토큰이 입력되지 않았습니다.", HttpStatus.BAD_REQUEST);


    private Integer code;
    private String errMsg;
    private HttpStatus httpStatus;

    ErrorMessage(int code, String errMsg, HttpStatus httpStatus) {
        this.code = code;
        this.errMsg = errMsg;
        this.httpStatus = httpStatus;
    }

    public int getErrorCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errMsg;
    }
}
