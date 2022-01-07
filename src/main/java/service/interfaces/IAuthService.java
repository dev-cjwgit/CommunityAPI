package service.interfaces;

import domain.vo.AuthVO;

public interface IAuthService {
    AuthVO authUser() throws Exception;
}
