package domain.entity;

public class BoardEmotion {
    protected Long board_uid;
    protected Long account_uid;
    protected Short status;

    public Long getBoard_uid() {
        return board_uid;
    }

    public Long getAccount_uid() {
        return account_uid;
    }

    public Short getStatus() {
        return status;
    }
}
