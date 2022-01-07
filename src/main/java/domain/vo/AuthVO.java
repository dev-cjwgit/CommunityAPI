package domain.vo;

public class AuthVO {
    private Long uid;
    private String nickname;

    public AuthVO(Long uid, String nickname) {
        this.uid = uid;
        this.nickname = nickname;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
