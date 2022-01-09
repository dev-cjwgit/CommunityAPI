package service.interfaces;

import domain.dto.AuthDTO;

public interface IAuthService {
    AuthDTO authUser() throws Exception;
}
