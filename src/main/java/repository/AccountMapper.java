package repository;

import domain.entity.origin_mapping.AccountEntity;
import domain.dto.AccountRegisterDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    void signup(@Param(value = "account") AccountRegisterDTO account);

    void reSignup(@Param(value = "uid") Long uid, @Param(value = "account") AccountRegisterDTO account);

    void withdraw(@Param(value = "uid") Long uid);

    Boolean isExistEmail(@Param(value = "email") String email);

    Boolean isExistNickName(@Param(value = "nickname") String nickname);

    Long getUidToEmail(@Param(value = "email") String email);

    void setSalt(@Param(value = "uid") Long uid, @Param(value = "salt") String salt);

    AccountEntity getLoginInfoToEmail(@Param(value = "email") String email);

    AccountEntity getWithdrawInfoToUid(@Param(value = "uid") Long uid);

    String getSaltToUid(@Param(value = "uid") Long uid);

    String getPasswordToEamil(@Param(value = "email") String email);
}
