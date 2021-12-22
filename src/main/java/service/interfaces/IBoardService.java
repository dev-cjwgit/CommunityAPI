package service.interfaces;

import domain.dto.BoardDTO;
import domain.vo.AccountRegisterVO;
import domain.vo.BoardVO;
import response.BaseResponse;

import java.util.List;

public interface IBoardService {
    BaseResponse createBoard(BoardVO board) throws Exception;

    List<BoardDTO> getSummaryBoardList() throws Exception;

    BoardDTO getBoardInfo(Long board_uid) throws Exception;

    BaseResponse updateBoard(BoardVO board) throws Exception;

    BaseResponse deleteBoard(Long uid) throws Exception;

}
