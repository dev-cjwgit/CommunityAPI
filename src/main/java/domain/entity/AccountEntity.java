package domain.entity;

import java.sql.Timestamp;

public class AccountEntity {
    protected Long uid;
    protected String email;
    protected String password;
    protected String name;
    protected String nickname;
    protected Long point;
    protected short level;
    protected Timestamp updated_at;
    protected Timestamp created_at;
    protected Timestamp deleted_at;
    protected String salt;

    public AccountEntity() {
    }

    public Long getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Long getPoint() {
        return point;
    }

    public short getLevel() {
        return level;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public String getSalt() {
        return salt;
    }
}
