package controller;

import annotation.ValidationGroups;
import domain.dto.AccountRegisterDTO;
import domain.dto.LoginDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.interfaces.IAccountService;

@Controller
public class AccountController {
    /**
     * TODO MEMO: JWT에 로그아웃 개념은??
     */
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ApiOperation(value = "회원가입", notes = "회원가입을 위한 API입니다. {이메일, 비밀번호, 실명, 닉네임}")
    public ResponseEntity signUp(@RequestBody @Validated(ValidationGroups.signUp.class) AccountRegisterDTO account) throws Exception {
        return new ResponseEntity(accountService.signUp(account), HttpStatus.OK);
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    @ApiOperation(value = "회원탈퇴", notes = "회원탈퇴을 위한 API입니다. {이메일, 비밀번호, 실명}")
    public ResponseEntity withdraw(@RequestBody @Validated(ValidationGroups.withdraw.class) AccountRegisterDTO account) throws Exception {
        return new ResponseEntity(accountService.withdraw(account), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "로그인", notes = "로그인을 위한 API입니다. {이메일, 비밀번호}")
    public ResponseEntity login(@RequestBody @Validated(ValidationGroups.login.class) LoginDTO account) throws Exception {
        return new ResponseEntity(accountService.login(account), HttpStatus.OK);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    @ApiOperation(value = "토근 재발행", notes = "토큰 재발행을 위한 API입니다. {토큰}")
    public ResponseEntity refresh() throws Exception {
        return new ResponseEntity(accountService.refresh(), HttpStatus.OK);
    }

    @RequestMapping(value = "/key-check", method = RequestMethod.POST)
    @ApiOperation(value = "토큰 확인", notes = "토큰을 확인하는 API입니다. {토큰}")
    public ResponseEntity checkKey(@RequestBody String key) throws Exception {
        return new ResponseEntity(accountService.checkKey(key), HttpStatus.OK);
    }
}
