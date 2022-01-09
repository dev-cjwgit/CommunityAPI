package domain.entity;

import java.sql.Timestamp;

public class BoardCommentDTO {
    private Long uid;
    private Long board_uid;
    private Long account_uid;
    private String body;
    private Timestamp update_at;
    private Timestamp create_at;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getBoard_uid() {
        return board_uid;
    }

    public void setBoard_uid(Long board_uid) {
        this.board_uid = board_uid;
    }

    public Long getAccount_uid() {
        return account_uid;
    }

    public void setAccount_uid(Long account_uid) {
        this.account_uid = account_uid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }
}
