package domain.dto;

import annotation.ValidationGroups;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountRegisterDTO {
    @NotNull(groups = {ValidationGroups.signUp.class}, message = "이메일은 공백일 수 없습니다.")
    @Email(groups = {ValidationGroups.signUp.class}, message = "이메일 형식이 아닙니다.")
    private String email;

    @NotNull(groups = {ValidationGroups.signUp.class}, message = "비밀번호는 공백일 수 없습니다.")
    @Size(min = 8, max = 30, groups = {ValidationGroups.signUp.class}, message = "비밀번호는은 8글자 이상 30글자 이하입니다.")
    private String password;

    @NotNull(groups = {ValidationGroups.signUp.class}, message = "이름은 공백일 수 없습니다.")
    @Size(min = 2, max = 20, groups = {ValidationGroups.signUp.class}, message = "이름은 2글자이상 20글자 이하입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{1,20}$", groups = {ValidationGroups.signUp.class}, message = "이름은 특수문자와 초성은 사용불가능합니다")
    private String name;

    @NotNull(groups = {ValidationGroups.signUp.class}, message = "별명은 공백일 수 없습니다.")
    @Size(min = 1, max = 30, groups = {ValidationGroups.signUp.class}, message = "별명은 1글자이상 30글자 이하입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{1,20}$", groups = {ValidationGroups.signUp.class}, message = "별명은 특수문자와 초성은 사용불가능합니다")
    private String nickname;

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
