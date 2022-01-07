package service;

import domain.dto.AccountDTO;
import domain.vo.AccountRegisterVO;
import domain.vo.AuthVO;
import domain.vo.LoginVO;
import enums.ErrorMessage;
import exception.RequestInputException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.AccountMapper;
import response.BaseResponse;
import service.interfaces.IAccountService;
import service.interfaces.IAuthService;
import util.Jwt;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private Jwt jwt;

    @Autowired
    private IAuthService authService;

    @Override
    public BaseResponse signUp(AccountRegisterVO account) throws Exception {
        // 이메일 중복체크
        if (accountMapper.isAccountToEmail(account.getEmail()) != 0)
            return new BaseResponse("이미 존재하는 이메일입니다.", HttpStatus.OK);

        // 닉네임 중복체크
        if (accountMapper.isAccountToNickName(account.getNickname()) != 0)
            return new BaseResponse("이미 존재하는 닉네임입니다.", HttpStatus.OK);

        // 비밀번호 암호화
        account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
        try {
            accountMapper.signUp(account);  // 회원 가입
        } catch (Exception ex) {
            return new BaseResponse("알 수 없는 원인으로 회원가입에 실패하였습니다.", HttpStatus.OK);
        }

        // salt를 설정해주기위해 uid를 가져옴
        Long uid = accountMapper.getUidToEmail(account.getEmail());

        // salt 생성을 위한 날짜
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String salt = uid.toString() + calendar.getTime();

        salt = (BCrypt.hashpw(salt, BCrypt.gensalt()));
        accountMapper.setSalt(uid, salt);

        return new BaseResponse("회원가입에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public Map<String, Object> checkKey(String token) throws Exception {
        return jwt.verifyJWT(token);
    }

    @Override
    public Map<String, String> login(LoginVO account) throws Exception {
        AccountDTO accountDTO = accountMapper.getLoginInfoToEmail(account.getEmail());
        if (accountDTO == null)
            throw new RequestInputException(ErrorMessage.LOGIN_NOT_EXIST_EMAIL);

        if (!BCrypt.checkpw(account.getPassword(), accountDTO.getPassword())) {
            throw new RequestInputException(ErrorMessage.LOGIN_NOT_PASSWORD);
        } else {
            Map<String, String> token = new HashMap<>();
            // 토큰 발급
            token.put("access_token", jwt.createToken(accountDTO));
            return token;
        }
    }

    @Override
    public Map<String, String> refresh() throws Exception {
        AuthVO authVO = authService.authUser();

        AccountDTO account = new AccountDTO();
        account.setUid(authVO.getUid());
        account.setNickname(authVO.getNickname());

        account.setSalt(accountMapper.getSaltToUid(authVO.getUid()));

        Map<String, String> refresh_token = new HashMap<>();
        // 토큰 재발급
        refresh_token.put("access_token", jwt.createToken(account));
        return refresh_token;
    }
}