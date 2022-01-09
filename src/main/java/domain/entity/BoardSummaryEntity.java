package domain.entity;

import java.sql.Timestamp;

public class BoardSummaryEntity {
    private Long uid;
    private String title;
    private String nickname;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Integer emotion;

    public Long getUid() {
        return uid;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getEmotion() {
        return emotion;
    }
}
