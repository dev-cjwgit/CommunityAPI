package service;

import domain.dto.AccountDTO;
import enums.ErrorMessage;
import exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import service.interfaces.IAuthService;
import util.Jwt;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private Jwt jwt;

    @Override
    public AccountDTO authUser() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        if (token == null)
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_EMPTY);
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_NOT_LOAD);

        return new AccountDTO(Long.parseLong(data.get("uid").toString()));
    }
}
