package service.interfaces;

import domain.dto.AccountDTO;

public interface IAuthService {
    AccountDTO authUser() throws Exception;
}
