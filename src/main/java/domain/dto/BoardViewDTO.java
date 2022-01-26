package domain.dto;

import java.sql.Timestamp;

public class BoardViewDTO {
    private Long boardUid;
    private Long accountUid;
    private Integer view;
    private Timestamp updatedAt;

    public Long getBoardUid() {
        return boardUid;
    }

    public void setBoardUid(Long boardUid) {
        this.boardUid = boardUid;
    }

    public Long getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(Long accountUid) {
        this.accountUid = accountUid;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
