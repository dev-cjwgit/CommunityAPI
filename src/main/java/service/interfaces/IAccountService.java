package service.interfaces;

import domain.dto.AccountDTO;
import response.BaseResponse;

import java.util.Map;

public interface IAccountService {
    BaseResponse signup(AccountDTO account) throws Exception;

    BaseResponse withdraw(AccountDTO account) throws Exception;

    Map<String, Object> checkKey(String key) throws Exception;

    Map<String, String> login(AccountDTO account) throws Exception;

    Map<String, String> refresh() throws Exception;
}
