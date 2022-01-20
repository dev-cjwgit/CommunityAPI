package service;

import domain.dto.AccountDTO;
import enums.ErrorMessage;
import exception.BaseException;
import exception.RequestInputException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.AccountMapper;
import response.BaseResponse;
import service.interfaces.IAccountService;
import service.interfaces.IAuthService;
import util.Jwt;

import java.util.*;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private Jwt jwt;

    @Autowired
    private IAuthService authService;

    private BaseResponse reSignup(AccountDTO account) throws Exception {
        /**
         * TODO MEMO: 맨 처음에 timestamp 비교하여 삭제 후 N일 가입 불가 기능 추가 가능
         * TODO: 삭제 시 따로 만들어서 저장해야 할 듯.
         * 현재 mariadb의 외래키 사용으로 전부 지워지긴 한데 이는 uid가 지워져야 가능한 일임.
         */

        // 닉네임 중복체크
        if (accountMapper.isExistNickName(account.getNickname()))
            throw new BaseException(ErrorMessage.SIGNUP_EXIST_NICKNAME);

        // 비밀번호 암호화
        account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));

        // salt를 설정해주기위해 uid를 가져옴
        Long uid = accountMapper.getUidToEmail(account.getEmail());

        accountMapper.reSignup(uid, account);  // 재 회원 가입

        // salt 생성을 위한 날짜
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String salt = uid.toString() + calendar.getTime();

        salt = (BCrypt.hashpw(salt, BCrypt.gensalt()));
        accountMapper.setSalt(uid, salt);

        return new BaseResponse("재 회원가입에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse signUp(AccountDTO account) throws Exception {
        // 이메일 중복체크
        if (accountMapper.isExistEmail(account.getEmail())) {
            if (accountMapper.getPasswordToEamil(account.getEmail()) == null)
                return reSignup(account);

            throw new BaseException(ErrorMessage.SIGNUP_EXIST_EMAIL);
        }

        // 닉네임 중복체크
        if (accountMapper.isExistNickName(account.getNickname()))
            throw new BaseException(ErrorMessage.SIGNUP_EXIST_NICKNAME);

        // 비밀번호 암호화
        account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));

        accountMapper.signup(account);  // 회원 가입

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
    public BaseResponse withdraw(AccountDTO account) throws Exception {
        AccountDTO servAccountDTO = authService.authUser();

        if (servAccountDTO == null)
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID);

        AccountDTO accountDTO = accountMapper.getWithdrawInfoToUid(servAccountDTO.getUid());

        if (accountDTO == null)
            throw new RequestInputException(ErrorMessage.LOGIN_NOT_EXIST_EMAIL);

        if (accountDTO.getPassword() == null)
            throw new RequestInputException(ErrorMessage.DONT_EXIST_ACCOUNT);

        if (!accountDTO.getEmail().equals(account.getEmail()) || !accountDTO.getName().equals(account.getName()))
            throw new RequestInputException(ErrorMessage.NOT_MATCH_ACCOUNT_INFO);


        if (!BCrypt.checkpw(account.getPassword(), accountDTO.getPassword())) {
            throw new RequestInputException(ErrorMessage.LOGIN_NOT_PASSWORD);
        } else {
            accountMapper.withdraw(servAccountDTO.getUid());
            return new BaseResponse("회원 탈퇴에 성공하였습니다.", HttpStatus.OK);
        }
    }

    @Override
    public Map<String, Object> checkKey(String token) throws Exception {
        return jwt.verifyJWT(token);
    }

    @Override
    public Map<String, String> login(AccountDTO account) throws Exception {
        AccountDTO accountDTO = accountMapper.getLoginInfoToEmail(account.getEmail());
        if (accountDTO == null)
            throw new RequestInputException(ErrorMessage.LOGIN_NOT_EXIST_EMAIL);

        if (accountDTO.getPassword() == null)
            throw new RequestInputException(ErrorMessage.DONT_EXIST_ACCOUNT);

        if (!BCrypt.checkpw(account.getPassword(), accountDTO.getPassword())) {
            throw new RequestInputException(ErrorMessage.LOGIN_NOT_PASSWORD);
        } else {
            Map<String, String> token = new HashMap<>();
            // 토큰 발급
            token.put("access_token", jwt.createToken(accountDTO.getUid(), accountDTO.getSalt()));
            return token;
        }
    }

    @Override
    public Map<String, String> refresh() throws Exception {
        AccountDTO servAccountDTO = authService.authUser();

        Map<String, String> refresh_token = new HashMap<>();
        // 토큰 재발급
        refresh_token.put("access_token", jwt.createToken(servAccountDTO.getUid(), accountMapper.getSaltToUid(servAccountDTO.getUid())));
        return refresh_token;
    }
}