package domain.vo;

public class BoardCommentVO {
    private Long uid;
    private Long board_uid;
    private Long account_uid;
    private String body;

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
}
