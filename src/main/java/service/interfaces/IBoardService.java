package service.interfaces;

import domain.entity.BoardDTO;
import domain.vo.BoardVO;
import response.BaseResponse;

import java.util.List;

public interface IBoardService {
    BaseResponse createBoard(BoardVO board) throws Exception;

    List<BoardDTO> getSummaryBoardList(int page, int range) throws Exception;

    BoardDTO getBoardInfo(Long board_uid) throws Exception;

    BaseResponse updateBoard(BoardVO board) throws Exception;

    BaseResponse deleteBoard(Long uid) throws Exception;

    Long getBoardListCnt() throws Exception;

    BaseResponse createBoardEmotion(Long board_uid, Integer status) throws Exception;

    BaseResponse deleteBoardEmotion(Long board_uid) throws Exception;

    Integer getBoardEmotion(Long board_uid) throws Exception;
}
