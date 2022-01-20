package repository;

import domain.dto.AccountDTO;
import domain.dto.AccountWithdrawDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountWithdrawMapper {
    AccountWithdrawDTO getData(@Param(value = "email") String email);

    void addData(@Param(value = "email") String email);

    void removeData(@Param(value = "email") String email);
}
