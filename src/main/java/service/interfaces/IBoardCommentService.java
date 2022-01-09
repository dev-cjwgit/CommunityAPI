package service.interfaces;

import domain.entity.BoardCommentDTO;
import domain.vo.BoardCommentVO;
import response.BaseResponse;

import java.util.List;

public interface IBoardCommentService {
    BaseResponse createComment(BoardCommentVO comment) throws Exception;

    List<BoardCommentDTO> getComment(Long board_uid, int page, int range) throws Exception;

    BaseResponse updateComment(BoardCommentVO comment) throws Exception;

    BaseResponse deleteComment(Long board_comment_uid) throws Exception;

    BaseResponse createBoardCommentEmotion(Long board_comment_uid, Integer status) throws Exception;

    BaseResponse deleteBoardCommentEmotion(Long board_comment_uid) throws Exception;

    Integer getBoardCommentEmotion(Long board_comment_uid) throws Exception;
}
