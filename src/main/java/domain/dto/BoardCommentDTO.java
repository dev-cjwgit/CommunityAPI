package domain.dto;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

public class BoardCommentDTO {
    private Long uid;
    private Long boardUid;

    @ApiModelProperty(hidden = true)
    private Long accountUid;
    @ApiModelProperty(hidden = true)
    private String nickname;

    private String body;
    @ApiModelProperty(hidden = true)
    private Timestamp createdAt;
    @ApiModelProperty(hidden = true)
    private Timestamp updatedAt;
    @ApiModelProperty(hidden = true)
    private Integer emotionCount;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(Long accountUid) {
        this.accountUid = accountUid;
    }

    public Long getBoardUid() {
        return boardUid;
    }

    public void setBoardUid(Long boardUid) {
        this.boardUid = boardUid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getEmotionCount() {
        return emotionCount;
    }

    public void setEmotionCount(Integer emotionCount) {
        this.emotionCount = emotionCount;
    }
}