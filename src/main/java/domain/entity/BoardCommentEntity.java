package domain.entity;

import java.sql.Timestamp;

public class BoardCommentEntity {
    protected Long uid;
    protected Long board_uid;
    protected Long account_uid;
    protected String body;
    protected Timestamp update_at;
    protected Timestamp create_at;

    public Long getUid() {
        return uid;
    }

    public Long getBoard_uid() {
        return board_uid;
    }

    public Long getAccount_uid() {
        return account_uid;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }
}
