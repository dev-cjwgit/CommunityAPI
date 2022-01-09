package service.interfaces;

import domain.dto.AccountRegisterDTO;
import domain.dto.LoginDTO;
import response.BaseResponse;

import java.util.Map;

public interface IAccountService {
    BaseResponse signUp(AccountRegisterDTO account) throws Exception;

    Map<String, Object> checkKey(String key) throws Exception;

    Map<String, String> login(LoginDTO account) throws Exception;

    Map<String, String> refresh() throws Exception;
}
