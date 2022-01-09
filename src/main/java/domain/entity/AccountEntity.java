package domain.entity;

import java.sql.Timestamp;

public class AccountEntity {
    private Long uid;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private Long point;
    private short level;
    private Timestamp updated_at;
    private Timestamp created_at;
    private Timestamp deleted_at;
    private String salt;

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
