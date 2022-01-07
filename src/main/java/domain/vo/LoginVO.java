package domain.vo;

import annotation.ValidationGroups;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginVO {
    @NotNull(groups = {ValidationGroups.login.class}, message = "이메일은 공백일 수 없습니다.")
    @Email(groups = {ValidationGroups.login.class}, message = "이메일 형식이 아닙니다.")
    private String email;

    @NotNull(groups = {ValidationGroups.login.class}, message = "비밀번호는 공백일 수 없습니다.")
    @Size(min = 8, max = 30, groups = {ValidationGroups.login.class}, message = "비밀번호는은 8글자 이상 30글자 이하입니다.")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
