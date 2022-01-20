package domain.dto;

import java.sql.Timestamp;

public class AccountWithdrawDTO {
    private String email;
    private Timestamp deletedAt;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
}
