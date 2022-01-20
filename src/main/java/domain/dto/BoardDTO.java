package domain.dto;

import domain.Pagination;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class BoardDTO {
    @ApiModelProperty(hidden = true)
    private Long uid;
    private String title;
    @ApiModelProperty(hidden = true)
    private Long accountUid;
    private String nickname;
    private String body;
    @ApiModelProperty(hidden = true)
    private Timestamp createdAt;
    @ApiModelProperty(hidden = true)
    private Timestamp updatedAt;
    @ApiModelProperty(hidden = true)
    private Integer emotionCount;
    @ApiModelProperty(hidden = true)
    private Map<Short, AccountDTO> emotionList;

    public BoardDTO() {

    }

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

    public Integer getEmotionCount() {
        return emotionCount;
    }

    public void setEmotionCount(Integer emotionCount) {
        this.emotionCount = emotionCount;
    }

    public Map<Short, AccountDTO> getEmotionList() {
        return emotionList;
    }

    public void setEmotionList(Map<Short, AccountDTO> emotionList) {
        this.emotionList = emotionList;
    }
}
