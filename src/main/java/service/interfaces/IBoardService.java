package service.interfaces;

import domain.dto.BoardEmotionDTO;
import domain.dto.BoardDTO;
import response.BaseResponse;

import java.util.List;

public interface IBoardService {
    BaseResponse createBoard(BoardDTO board) throws Exception;

    List<BoardDTO> getSummaryBoardList(BoardDTO board) throws Exception;

    List<BoardDTO> searchSummaryBoardTitleBody(String title, String body, int page, int range) throws Exception;

    List<BoardDTO> searchSummaryBoardNickName(String nickname, int page, int range) throws Exception;

    List<BoardDTO> searchSummaryBoardCommentNickName(String nickname, int page, int range) throws Exception;

    BoardDTO getBoardInfo(Long board_uid) throws Exception;

    BaseResponse updateBoard(BoardDTO board) throws Exception;

    BaseResponse deleteBoard(Long uid) throws Exception;

    BaseResponse createBoardEmotion(Long board_uid, Integer status) throws Exception;

    BaseResponse deleteBoardEmotion(Long board_uid) throws Exception;

    List<BoardEmotionDTO> getBoardEmotion(Long board_uid) throws Exception;
}
