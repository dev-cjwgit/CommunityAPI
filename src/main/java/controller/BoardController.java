package controller;

import domain.dto.BoardDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.interfaces.IBoardService;

@Controller
public class BoardController {
    /**
     *
     */
    @Autowired
    private IBoardService boardService;

    //region Board CRUD
    @RequestMapping(value = "/board", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 생성", notes = "게시글을 생성하기 위한 API입니다. {제목, 내용}")
    public ResponseEntity signUp(@RequestBody @Validated(BoardDTO.class) BoardDTO board) throws Exception {
        return new ResponseEntity(boardService.createBoard(board), HttpStatus.OK);
    }

    @RequestMapping(value = "/summaryboard", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 목록 요약 보기", notes = "게시글 요약 목록을 보기 위한 API입니다.")
    public ResponseEntity searchSummaryBoard(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int range) throws Exception {
        return new ResponseEntity(boardService.getSummaryBoardList(page, range), HttpStatus.OK);
    }

    @RequestMapping(value = "/search/summaryboard/titlebody", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 제목, 내용 검색", notes = "게시글 제목 및 내용을 검색하기 위한 API입니다.")
    public ResponseEntity getSummaryBoardListTitle(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false, defaultValue = "") String body, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int range) throws Exception {
        return new ResponseEntity(boardService.searchSummaryBoardTitleBody(title, body, page, range), HttpStatus.OK);
    }

    @RequestMapping(value = "/search/summaryboard/nickname", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 제목, 내용 검색", notes = "게시글 제목 및 내용을 검색하기 위한 API입니다.")
    public ResponseEntity getSummaryBoardListNickName(String nickname, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int range) throws Exception {
        return new ResponseEntity(boardService.searchSummaryBoardNickName(nickname, page, range), HttpStatus.OK);
    }

    @RequestMapping(value = "/search/summaryboard/comment/nickname", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 제목, 내용 검색", notes = "게시글 제목 및 내용을 검색하기 위한 API입니다.")
    public ResponseEntity getSummaryBoardListCommentNickName(String nickname, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int range) throws Exception {
        return new ResponseEntity(boardService.searchSummaryBoardNickName(nickname, page, range), HttpStatus.OK);
    }

    @RequestMapping(value = "/boardinfo", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 상세 보기", notes = "게시글을 상세하게 보기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity getBoardInfo(Long board_uid) throws Exception {
        return new ResponseEntity(boardService.getBoardInfo(board_uid), HttpStatus.OK);
    }

    @RequestMapping(value = "/board", method = RequestMethod.PUT)
    @ApiOperation(value = "게시글 수정", notes = "게시글을 수정하기 위한 API입니다. {게시글 고유번호, 제목, 내용}")
    public ResponseEntity updateBoard(@RequestBody @Validated(BoardDTO.class) BoardDTO board) throws Exception {
        return new ResponseEntity(boardService.updateBoard(board), HttpStatus.OK);
    }

    @RequestMapping(value = "/board", method = RequestMethod.DELETE)
    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제하기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity deleteBoard(@RequestBody Long board_uid) throws Exception {
        return new ResponseEntity(boardService.deleteBoard(board_uid), HttpStatus.OK);
    }
    //endregion

    @RequestMapping(value = "/board/emotion", method = RequestMethod.POST)
    @ApiOperation(value = "게시글 감정표현", notes = "게시글 감정표현을 달기 위한 API입니다. {게시판 고유번호, 공감상태}")
    public ResponseEntity createBoardEmotion(@RequestBody Long board_uid, Integer status) throws Exception {
        return new ResponseEntity(boardService.createBoardEmotion(board_uid, status), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/emotion", method = RequestMethod.DELETE)
    @ApiOperation(value = "게시글 감정표현 취소", notes = "게시글 감정표현을 취소 위한 API입니다. {게시판 고유번호}")
    public ResponseEntity deleteBoardEmotion(@RequestBody Long board_uid) throws Exception {
        return new ResponseEntity(boardService.deleteBoardEmotion(board_uid), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/emotion", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 감정표현 상세내역", notes = "게시글 감정표현의 상세 내역을 보기 위한 API입니다. {게시판 고유번호}")
    public ResponseEntity getBoardEmotion(Long board_uid) throws Exception {
        return new ResponseEntity(boardService.getBoardEmotion(board_uid), HttpStatus.OK);
    }
}