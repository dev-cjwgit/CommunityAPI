package domain.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.sql.Timestamp;
import java.util.List;

public class BoardDTO {
    @ApiModelProperty(hidden = true)
    private Long uid;
    private String title;
    @ApiModelProperty(hidden = true)
    private Long accountUid;
    private String nickname;
    private String body;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ApiModelProperty(hidden = true)
    private Integer emotionCount;
    @ApiModelProperty(hidden = true)
    private List<AccountDTO> emotionList;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getEmotion() {
        return emotionCount;
    }

    public void setEmotion(Integer emotionCount) {
        this.emotionCount = emotionCount;
    }

    public List<AccountDTO> getEmotionList() {
        return emotionList;
    }

    public void setEmotionList(List<AccountDTO> emotionList) {
        this.emotionList = emotionList;
    }
}
