package domain.vo;

public class AuthVO {
    private Long uid;

    public AuthVO(Long uid, String nickname) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
