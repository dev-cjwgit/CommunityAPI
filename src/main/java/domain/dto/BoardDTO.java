package domain.dto;

import java.util.List;

public class BoardDTO extends BoardSummaryDTO {
    private String body;
    private Long accountUid;
    private List<AccountDTO> emotionList;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(Long accountUid) {
        this.accountUid = accountUid;
    }
}
