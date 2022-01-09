package domain.entity;

public class BoardEntity extends BoardSummaryEntity {
    private String body;
    private Long account_uid;

    public String getBody() {
        return body;
    }

    public Long getAccount_uid() {
        return account_uid;
    }
}
