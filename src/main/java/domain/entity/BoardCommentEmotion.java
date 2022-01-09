package domain.entity;

public class BoardCommentEmotion {
    protected Long board_comment_uid;
    protected Long account_uid;
    protected Short status;

    public Long getBoard_comment_uid() {
        return board_comment_uid;
    }

    public Long getAccount_uid() {
        return account_uid;
    }

    public Short getStatus() {
        return status;
    }
}
