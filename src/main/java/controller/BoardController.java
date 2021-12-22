package controller;

import domain.vo.AccountRegisterVO;
import domain.vo.BoardVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.interfaces.IAccountService;
import service.interfaces.IBoardService;

@Controller
public class BoardController {
    @Autowired
    private IBoardService boardService;

    @RequestMapping(value = "/create-board", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 생성", notes = "게시글을 생성하기 위한 API입니다. {제목, 내용}")
    public ResponseEntity signUp(@RequestBody @Validated(BoardVO.class) BoardVO board) throws Exception {
        return new ResponseEntity(boardService.createBoard(board), HttpStatus.OK);
    }
}
