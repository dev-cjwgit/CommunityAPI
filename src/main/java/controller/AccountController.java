package controller;

import domain.AccountDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import service.interfaces.IAccountService;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    @ApiOperation(value = "회원가입", notes = "회원가입을 위한 API입니다. {이메일, 비밀번호, 실명, 닉네임}")
    public ResponseEntity signUp(@ModelAttribute AccountDTO account) throws Exception {
        return new ResponseEntity(accountService.signUp(account), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "로그인", notes = "로그인을 위한 API입니다. {이메일, 비밀번호}")
    public ResponseEntity login(@ModelAttribute AccountDTO account) throws Exception {
        return new ResponseEntity(accountService.login(account), HttpStatus.OK);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    @ApiOperation(value = "토근 재발행", notes = "토큰 재발행을 위한 API입니다. {토큰}")
    public ResponseEntity refresh(String token) throws Exception {
        return new ResponseEntity(accountService.refresh(token), HttpStatus.OK);
    }

    @RequestMapping(value = "/key-check", method = RequestMethod.GET)
    @ApiOperation(value = "토큰 확인", notes = "토큰을 확인하는 APi입니다. {토큰}")
    public ResponseEntity checkKey(String key) throws Exception {
        return new ResponseEntity(accountService.checkKey(key), HttpStatus.OK);
    }
}
