package service.interfaces;

import domain.Pagination;
import domain.dto.BoardCommentEmotionDTO;
import domain.dto.BoardCommentDTO;
import response.BaseResponse;

import java.util.List;

public interface IBoardCommentService {
    BaseResponse createComment(BoardCommentDTO comment) throws Exception;

    List<BoardCommentDTO> getComment(Long board_uid, Pagination page) throws Exception;

    BaseResponse updateComment(BoardCommentDTO comment) throws Exception;

    BaseResponse deleteComment(Long board_comment_uid) throws Exception;

    BaseResponse createBoardCommentEmotion(Long board_comment_uid, Integer status) throws Exception;

    BaseResponse deleteBoardCommentEmotion(Long board_comment_uid) throws Exception;

    List<BoardCommentEmotionDTO> getBoardCommentEmotion(Long board_comment_uid) throws Exception;
}
