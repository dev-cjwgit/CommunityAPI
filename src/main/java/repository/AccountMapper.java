package repository;

import domain.dto.AccountDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    void signup(@Param(value = "account") AccountDTO account);

    void reSignup(@Param(value = "uid") Long uid, @Param(value = "account") AccountDTO account);

    void withdraw(@Param(value = "uid") Long uid);

    Boolean isExistEmail(@Param(value = "email") String email);

    Boolean isExistNickName(@Param(value = "nickname") String nickname);

    Long getUidToEmail(@Param(value = "email") String email);

    void setSalt(@Param(value = "uid") Long uid, @Param(value = "salt") String salt);

    AccountDTO getLoginInfoToEmail(@Param(value = "email") String email);

    AccountDTO getWithdrawInfoToUid(@Param(value = "uid") Long uid);

    String getSaltToUid(@Param(value = "uid") Long uid);

    String getPasswordToEamil(@Param(value = "email") String email);
}
