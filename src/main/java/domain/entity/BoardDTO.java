package domain.entity;


import java.sql.Timestamp;

public class BoardDTO {
    private Long uid;
    private String title;
    private String body;
    private Long account_uid;
    private Timestamp create_at;
    private Timestamp update_at;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAccount_uid() {
        return account_uid;
    }

    public void setAccount_uid(Long account_uid) {
        this.account_uid = account_uid;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }
}
