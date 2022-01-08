package repository;

import domain.dto.AccountDTO;
import domain.vo.AccountRegisterVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    void signUp(@Param(value = "account") AccountRegisterVO account);

    Boolean isExistEmail(@Param(value = "email") String email);

    Boolean isExistNickName(@Param(value = "nickname") String nickname);

    Long getUidToEmail(@Param(value = "email") String email);

    void setSalt(@Param(value = "uid") Long uid, @Param(value = "salt") String salt);

    AccountDTO getLoginInfoToEmail(@Param(value = "email") String email);

    String getSaltToUid(@Param(value = "uid") Long uid);
}
