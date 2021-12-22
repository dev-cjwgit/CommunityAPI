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

    //region Board CRUD
    @RequestMapping(value = "/create-board", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 생성", notes = "게시글을 생성하기 위한 API입니다. {제목, 내용}")
    public ResponseEntity signUp(@RequestBody @Validated(BoardVO.class) BoardVO board) throws Exception {
        return new ResponseEntity(boardService.createBoard(board), HttpStatus.OK);
    }

    @RequestMapping(value = "/read-summaryboardlist", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 목록 요약 보기", notes = "게시글 요약 목록을 보기 위한 API입니다.")
    public ResponseEntity getSummaryBoardList() throws Exception {
        return new ResponseEntity(boardService.getSummaryBoardList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/read-boardinfo", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 상세 보기", notes = "게시글을 상세하게 보기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity getBoardInfo(@RequestBody Long board_uid) throws Exception {
        return new ResponseEntity(boardService.getBoardInfo(board_uid), HttpStatus.OK);
    }

    @RequestMapping(value = "/update-board", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 수정", notes = "게시글을 수정하기 위한 API입니다. {게시글 고유번호, 제목, 내용}")
    public ResponseEntity updateBoard(@RequestBody @Validated(BoardVO.class) BoardVO board) throws Exception {
        return new ResponseEntity(boardService.updateBoard(board), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-board", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제하기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity deleteBoard(@RequestBody Long board_uid) throws Exception {
        return new ResponseEntity(boardService.deleteBoard(board_uid), HttpStatus.OK);
    }
    //endregion

    //region Board Comment CRUD


    //endregion

}
