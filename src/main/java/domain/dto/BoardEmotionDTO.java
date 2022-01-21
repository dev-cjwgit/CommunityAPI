package domain.dto;

import io.swagger.annotations.ApiModelProperty;

public class BoardEmotionDTO {
    private Long boardUid;
    @ApiModelProperty(hidden = true)
    private Long accountUid;
    @ApiModelProperty(hidden = true)
    private String nickname;
    private Short status;

    public Long getBoardUid() {
        return boardUid;
    }

    public void setBoardUid(Long boardUid) {
        this.boardUid = boardUid;
    }

    public Long getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(Long accountUid) {
        this.accountUid = accountUid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
