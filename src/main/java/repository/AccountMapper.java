package repository;

import domain.AccountDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import response.BaseResponse;

import java.util.List;

@Repository
public interface AccountMapper {
    void signUp(@Param(value = "account") AccountDTO account);

    short isAccountToEmail(@Param(value = "email") String email);

    short isAccountToNickName(@Param(value = "nickname") String nickname);

    Long getUidToEmail(@Param(value = "email") String email);

    String getPasswordToEmail(@Param(value = "email") String email);

    void setSalt(@Param(value = "uid") Long uid, @Param(value = "salt") String salt);

    AccountDTO getAccountToEmail(@Param(value = "email") String email);

    String getSaltToUid(@Param(value = "uid") Long uid);
}
