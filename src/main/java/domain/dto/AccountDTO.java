package domain.dto;

import annotation.ValidationGroups;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class AccountDTO {
    @ApiModelProperty(hidden = true)
    private Long uid;

    @NotNull(groups = {ValidationGroups.signup.class, ValidationGroups.withdraw.class}, message = "이메일은 공백일 수 없습니다.")
    @Email(groups = {ValidationGroups.signup.class}, message = "이메일 형식이 아닙니다.")
    private String email;

    @NotNull(groups = {ValidationGroups.signup.class}, message = "비밀번호는 공백일 수 없습니다.")
    @Size(min = 8, max = 30, groups = {ValidationGroups.signup.class, ValidationGroups.withdraw.class}, message = "비밀번호는은 8글자 이상 30글자 이하입니다.")
    private String password;

    @NotNull(groups = {ValidationGroups.signup.class}, message = "이름은 공백일 수 없습니다.")
    @Size(min = 2, max = 20, groups = {ValidationGroups.signup.class, ValidationGroups.withdraw.class}, message = "이름은 2글자이상 20글자 이하입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{1,20}$", groups = {ValidationGroups.signup.class}, message = "이름은 특수문자와 초성은 사용불가능합니다")
    private String name;

    @NotNull(groups = {ValidationGroups.signup.class}, message = "별명은 공백일 수 없습니다.")
    @Size(min = 1, max = 30, groups = {ValidationGroups.signup.class}, message = "별명은 1글자이상 30글자 이하입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{1,20}$", groups = {ValidationGroups.signup.class}, message = "별명은 특수문자와 초성은 사용불가능합니다")
    private String nickname;

    @ApiModelProperty(hidden = true)
    private Integer point;

    @ApiModelProperty(hidden = true)
    private Integer level;

    @ApiModelProperty(hidden = true)
    private Timestamp created_at;

    @ApiModelProperty(hidden = true)
    private Timestamp updatedAt;

    @ApiModelProperty(hidden = true)
    private Timestamp deletedAt;

    @ApiModelProperty(hidden = true)
    private String salt;

    public AccountDTO() {
    }

    public AccountDTO(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

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

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
