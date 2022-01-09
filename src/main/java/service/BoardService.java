package service;

import domain.entity.BoardEntity;
import domain.dto.AuthDTO;
import domain.dto.BoardDTO;
import enums.ErrorMessage;
import exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.BoardMapper;
import response.BaseResponse;
import service.interfaces.IAuthService;
import service.interfaces.IBoardService;

import java.util.List;

@Service
public class BoardService implements IBoardService {
    /**
     *
     */
    @Autowired
    private AccountService accountService;

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private IAuthService authService;

    @Override
    public BaseResponse createBoard(BoardDTO board) throws Exception {
        AuthDTO authVO = authService.authUser();

        boardMapper.createBoard(authVO.getUid(), board);

        return new BaseResponse("게시글 등록에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public List<BoardEntity> getSummaryBoardList(int page, int range) throws Exception {
        page = (page - 1) * range;
        return boardMapper.getSummaryBoardList(page, range);
    }

    @Override
    public BoardEntity getBoardInfo(Long board_uid) throws Exception {
        AuthDTO authVO = authService.authUser();

//        long user_uid = Long.parseLong(data.get("uid").toString());
        Long board_onwer = boardMapper.getAccountUid(board_uid);

        if (board_onwer == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD);

        return boardMapper.getBoardInfo(board_uid);
    }

    @Override
    public BaseResponse updateBoard(BoardDTO board) throws Exception {
        AuthDTO authVO = authService.authUser();


        long user_uid = authVO.getUid();
        Long board_onwer = boardMapper.getAccountUid(board.getUid());

        if (board_onwer == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD);


        if (board_onwer != user_uid)
            throw new BaseException(ErrorMessage.PERMISSION_EXCEPTION);

        boardMapper.updateBoard(board);

        return new BaseResponse("게시글 수정에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoard(Long board_uid) throws Exception {
        AuthDTO authVO = authService.authUser();

        long user_uid = authVO.getUid();
        Long board_onwer = boardMapper.getAccountUid(board_uid);

        if (board_onwer == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD);


        if (board_onwer != user_uid)
            throw new BaseException(ErrorMessage.PERMISSION_EXCEPTION);

        boardMapper.deleteBoard(board_uid);

        return new BaseResponse("게시글 삭제에 성공했습니다.", HttpStatus.OK);

    }

    @Override
    public Long getBoardListCnt() throws Exception {
        AuthDTO authVO = authService.authUser();

        return boardMapper.getBoardListCnt();
    }

    @Override
    public BaseResponse createBoardEmotion(Long board_uid, Integer status) throws Exception {
        /**
         * TODO: 게시판 고유번호 확인 필요
         * TODO: 중복 예외 처리 필요
         * TODO: 공감 상태 enum 확인 필요
         */
        AuthDTO authVO = authService.authUser();

        long user_uid = authVO.getUid();
        boardMapper.createBoardEmotion(board_uid, user_uid, status);

        return new BaseResponse("공감에 성공하였습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoardEmotion(Long board_uid) throws Exception {
        /**
         * TODO: 게시판 고유번호 확인 필요
         * TODO: 없는 것에 대한 취소 시 예외 처리 필요
         */
        AuthDTO authVO = authService.authUser();

        long user_uid = authVO.getUid();

        boardMapper.deleteBoardEmotion(board_uid, user_uid);

        return new BaseResponse("공감에 취소에 성공하였습니다.", HttpStatus.OK);

    }

    @Override
    public Integer getBoardEmotion(Long board_uid) throws Exception {
        AuthDTO authVO = authService.authUser();

        return boardMapper.getBoardEmotion(board_uid);
    }
}
