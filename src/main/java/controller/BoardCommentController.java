package controller;

import domain.dto.BoardCommentDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.interfaces.IBoardCommentService;

@Controller
public class BoardCommentController {
    /**
     */
    @Autowired
    private IBoardCommentService boardCommentService;

    @RequestMapping(value = "/board/comment", method = RequestMethod.POST)
    @ApiOperation(value = "댓글 생성", notes = "게시글에 댓글을 생성하기 위한 API입니다. {게시글 고유번호, 내용}")
    public ResponseEntity createComment(@RequestBody @Validated(BoardCommentDTO.class) BoardCommentDTO boardComment) throws Exception {
        return new ResponseEntity(boardCommentService.createComment(boardComment), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/comment", method = RequestMethod.GET)
    @ApiOperation(value = "댓글 불러오기", notes = "게시글에 댓글을 불러오기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity getComment(Long boardUid, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int range) throws Exception {
        return new ResponseEntity(boardCommentService.getComment(boardUid, page, range), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/comment", method = RequestMethod.PUT)
    @ApiOperation(value = "댓글 수정", notes = "게시글에 댓글을 수정하기 위한 API입니다. {댓글 고유번호, 내용}")
    public ResponseEntity updateComment(@RequestBody @Validated(BoardCommentDTO.class) BoardCommentDTO boardComment) throws Exception {
        return new ResponseEntity(boardCommentService.updateComment(boardComment), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/comment", method = RequestMethod.DELETE)
    @ApiOperation(value = "댓글 삭제", notes = "게시글에 댓글을 삭제하기 위한 API입니다. {게시글 고유번호}")
    public ResponseEntity deleteComment(Long boardCommentUid) throws Exception {
        return new ResponseEntity(boardCommentService.deleteComment(boardCommentUid), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/comment/emotion", method = RequestMethod.POST)
    @ApiOperation(value = "댓글 감정표현", notes = "댓글에 감정표현을 달기 위한 API입니다. {댓글 고유번호, 공감상태}")
    public ResponseEntity createBoardCommentEmotion(@RequestBody Long boardCommentUid, Integer status) throws Exception {
        return new ResponseEntity(boardCommentService.createBoardCommentEmotion(boardCommentUid, status), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/comment/emotion", method = RequestMethod.DELETE)
    @ApiOperation(value = "댓글 감정표현 취소", notes = "댓글에 감정표현을 취소 위한 API입니다. {댓글 고유번호}")
    public ResponseEntity deleteBoardCommentEmotion(@RequestBody Long boardCommentUid) throws Exception {
        return new ResponseEntity(boardCommentService.deleteBoardCommentEmotion(boardCommentUid), HttpStatus.OK);
    }

    @RequestMapping(value = "/board/comment/emotion", method = RequestMethod.GET)
    @ApiOperation(value = "댓글 감정표현 상세 내역", notes = "댓글에 감정표현의 상세내역을 보기 위한 API입니다. {댓글 고유번호}")
    public ResponseEntity getBoardCommentEmotion(Long boardCommentUid) throws Exception {
        return new ResponseEntity(boardCommentService.getBoardCommentEmotion(boardCommentUid), HttpStatus.OK);
    }
}
