package service.interfaces;

import domain.dto.AccountDTO;
import domain.vo.AccountRegisterVO;
import domain.vo.LoginVO;
import response.BaseResponse;

import java.util.Map;

public interface IAccountService {
    BaseResponse signUp(AccountRegisterVO account) throws Exception;

    Map<String, Object> checkKey(String key) throws Exception;

    Map<String, String> login(LoginVO account) throws Exception;

    Map<String, String> refresh() throws Exception;
}
