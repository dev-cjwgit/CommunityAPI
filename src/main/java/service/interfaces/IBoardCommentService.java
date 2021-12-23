package service.interfaces;

import domain.dto.BoardCommentDTO;
import domain.vo.BoardCommentVO;
import domain.vo.BoardVO;
import response.BaseResponse;

import java.util.List;

public interface IBoardCommentService {
    BaseResponse createComment(BoardCommentVO comment) throws Exception;
    List<BoardCommentDTO> getComment(Long board_uid) throws Exception;
    BaseResponse updateComment(BoardCommentVO comment) throws Exception;
    BaseResponse deleteComment(BoardCommentVO comment) throws Exception;

}
