package domain.entity;


import java.sql.Timestamp;

public class BoardEntity {
    protected Long uid;
    protected String title;
    protected String body;
    protected Long account_uid;
    protected Timestamp created_at;
    protected Timestamp updated_at;

    public Long getUid() {
        return uid;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Long getAccount_uid() {
        return account_uid;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }
}
