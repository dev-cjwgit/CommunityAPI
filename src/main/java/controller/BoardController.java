package controller;

import domain.vo.AccountRegisterVO;
import domain.vo.BoardVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.interfaces.IAccountService;
import service.interfaces.IBoardService;

@Controller
public class BoardController {
    /**
     * TODO: board emotion 누가 공감 눌렀는지 확인하는 서비스 필요
     * TODO MEMO: 게시글 목록 불러 올 때 게시글 공감 수도 같이 불러와야 하는가
     */
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
    public ResponseEntity getSummaryBoardList(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int range) throws Exception {
        return new ResponseEntity(boardService.getSummaryBoardList(page, range), HttpStatus.OK);
    }

    @RequestMapping(value = "/read-boardinfo", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 상세 보기", notes = "게시글을 상세하게 보기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity getBoardInfo(Long board_uid) throws Exception {
        return new ResponseEntity(boardService.getBoardInfo(board_uid), HttpStatus.OK);
    }

    @RequestMapping(value = "/update-board", method = RequestMethod.PUT)
    @ApiOperation(value = "게시글 수정", notes = "게시글을 수정하기 위한 API입니다. {게시글 고유번호, 제목, 내용}")
    public ResponseEntity updateBoard(@RequestBody @Validated(BoardVO.class) BoardVO board) throws Exception {
        return new ResponseEntity(boardService.updateBoard(board), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-board", method = RequestMethod.DELETE)
    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제하기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity deleteBoard(@RequestBody Long board_uid) throws Exception {
        return new ResponseEntity(boardService.deleteBoard(board_uid), HttpStatus.OK);
    }
    //endregion

    @RequestMapping(value = "/board/emotion", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 감정표현", notes = "게시글에 감정표현을 달기 위한 API입니다. {게시판 고유번호, 공감상태}")
    public ResponseEntity createBoardEmotion(@RequestBody Long board_uid, Integer status) throws Exception {
        return new ResponseEntity(boardService.createBoardEmotion(board_uid, status), HttpStatus.OK);
    }

    @RequestMapping(value = "board/emotion", method = RequestMethod.DELETE)
    @ApiOperation(value = "게시글 감정표현 취소", notes = "게시글에 감정표현을 취소 위한 API입니다. {게시판 고유번호}")
    public ResponseEntity deleteBoardEmotion(@RequestBody Long board_uid) throws Exception {
        return new ResponseEntity(boardService.deleteBoardEmotion(board_uid), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/emotion", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 감정표현 개수", notes = "게시글에 감정표현의 개수를 보기 위한 API입니다. {게시판 고유번호}")
    public ResponseEntity getBoardEmotion(Long board_uid) throws Exception {
        return new ResponseEntity(boardService.getBoardEmotion(board_uid), HttpStatus.OK);
    }
}