package service.interfaces;

import domain.entity.BoardCommentEmotionEntity;
import domain.entity.BoardCommentEntity;
import domain.dto.BoardCommentDTO;
import response.BaseResponse;

import java.util.List;

public interface IBoardCommentService {
    BaseResponse createComment(BoardCommentDTO comment) throws Exception;

    List<BoardCommentEntity> getComment(Long board_uid, int page, int range) throws Exception;

    BaseResponse updateComment(BoardCommentDTO comment) throws Exception;

    BaseResponse deleteComment(Long board_comment_uid) throws Exception;

    BaseResponse createBoardCommentEmotion(Long board_comment_uid, Integer status) throws Exception;

    BaseResponse deleteBoardCommentEmotion(Long board_comment_uid) throws Exception;

    List<BoardCommentEmotionEntity> getBoardCommentEmotion(Long board_comment_uid) throws Exception;
}
