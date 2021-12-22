package service.interfaces;

import domain.vo.AccountRegisterVO;
import domain.vo.BoardVO;
import response.BaseResponse;

public interface IBoardService {
    BaseResponse createBoard(BoardVO board) throws Exception;

}
