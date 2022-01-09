package domain.entity;

import java.sql.Timestamp;

public class BoardCommentEntity {
    private Long uid;
    private Long account_uid;
    private String nickname;
    private String body;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Integer emotion;

    public Long getUid() {
        return uid;
    }

    public Long getAccount_uid() {
        return account_uid;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Integer getEmotion() {
        return emotion;
    }

    public String getNickname() {
        return nickname;
    }
}