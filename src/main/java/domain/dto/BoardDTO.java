package domain.dto;

import domain.dto.BoardSummaryDTO;

public class BoardDTO extends BoardSummaryDTO {
    private String body;
    private Long accountUid;

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
