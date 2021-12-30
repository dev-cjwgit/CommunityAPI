package controller;

import domain.vo.BoardCommentVO;
import domain.vo.BoardVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.interfaces.IAccountService;
import service.interfaces.IBoardCommentService;

@Controller
public class BoardCommentController {
    @Autowired
    private IBoardCommentService boardCommentService;

    @RequestMapping(value = "/create-board-comment", method = RequestMethod.POST)
    @ApiOperation(value = "댓글 생성", notes = "게시글에 댓글을 생성하기 위한 API입니다. {게시글 고유번호, 내용}")
    public ResponseEntity createComment(@RequestBody @Validated(BoardCommentVO.class) BoardCommentVO boardComment) throws Exception {
        return new ResponseEntity(boardCommentService.createComment(boardComment), HttpStatus.OK);
    }

    @RequestMapping(value = "/read-board-comment", method = RequestMethod.GET)
    @ApiOperation(value = "댓글 불러오기", notes = "게시글에 댓글을 불러오기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity getComment(Long board_uid, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int range) throws Exception {
        return new ResponseEntity(boardCommentService.getComment(board_uid, page, range), HttpStatus.OK);
    }

    @RequestMapping(value = "/update-board-comment", method = RequestMethod.PUT)
    @ApiOperation(value = "댓글 수정", notes = "게시글에 댓글을 수정하기 위한 API입니다. {게시글 고유번호, 내용}")
    public ResponseEntity updateComment(@RequestBody @Validated(BoardCommentVO.class) BoardCommentVO boardComment) throws Exception {
        return new ResponseEntity(boardCommentService.updateComment(boardComment), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-board-comment", method = RequestMethod.DELETE)
    @ApiOperation(value = "댓글 삭제", notes = "게시글에 댓글을 삭제하기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity deleteComment(Long board_comment_uid) throws Exception {
        return new ResponseEntity(boardCommentService.deleteComment(board_comment_uid), HttpStatus.OK);
    }
}
