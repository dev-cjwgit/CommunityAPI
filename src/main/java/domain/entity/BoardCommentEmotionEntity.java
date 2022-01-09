package domain.entity;

public class BoardCommentEmotionEntity {
    private Long account_uid;
    private String nickname;
    private Short status;


    public Long getAccount_uid() {
        return account_uid;
    }

    public String getNickname() {
        return nickname;
    }

    public Short getStatus() {
        return status;
    }
}
