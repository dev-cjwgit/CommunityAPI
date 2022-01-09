package service.interfaces;

import domain.entity.BoardEntity;
import domain.dto.BoardDTO;
import domain.entity.BoardSummaryEntity;
import response.BaseResponse;

import java.util.List;

public interface IBoardService {
    BaseResponse createBoard(BoardDTO board) throws Exception;

    List<BoardSummaryEntity> getSummaryBoardList(int page, int range) throws Exception;

    BoardEntity getBoardInfo(Long board_uid) throws Exception;

    BaseResponse updateBoard(BoardDTO board) throws Exception;

    BaseResponse deleteBoard(Long uid) throws Exception;

    Long getBoardListCnt() throws Exception;

    BaseResponse createBoardEmotion(Long board_uid, Integer status) throws Exception;

    BaseResponse deleteBoardEmotion(Long board_uid) throws Exception;

    Integer getBoardEmotion(Long board_uid) throws Exception;
}
