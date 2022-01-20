package service;

import domain.dto.AccountDTO;
import domain.dto.BoardCommentEmotionDTO;
import domain.dto.BoardCommentDTO;
import domain.dto.BoardDTO;
import enums.ErrorMessage;
import exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.BoardCommentMapper;
import repository.BoardMapper;
import response.BaseResponse;
import service.interfaces.IAuthService;
import service.interfaces.IBoardCommentService;

import java.util.List;

@Service
public class BoardCommentService implements IBoardCommentService {
    /**
     *
     */
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardCommentMapper boardCommentMapper;

    @Autowired
    private IAuthService authService;


    @Override
    public BaseResponse createComment(BoardCommentDTO comment) throws Exception {
        AccountDTO servAccountDTO = authService.authUser();

        BoardDTO board = boardMapper.getBoardInfo(comment.getUid());

        if (board == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD);

        long user_uid = servAccountDTO.getUid();

        comment.setAccountUid(user_uid);

        boardCommentMapper.createComment(comment);

        return new BaseResponse("댓글 등록에 성공했습니다.", HttpStatus.OK);

    }

    @Override
    public List<BoardCommentDTO> getComment(Long board_uid, int page, int range) throws Exception {
        AccountDTO servAccountDTO = authService.authUser();

        BoardDTO board = boardMapper.getBoardInfo(board_uid);

        if (board == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD);

        page = (page - 1) * range;
        return boardCommentMapper.getComment(board_uid, page, range);
    }

    @Override
    public BaseResponse updateComment(BoardCommentDTO comment) throws Exception {
        AccountDTO servAccountDTO = authService.authUser();

        long user_uid = servAccountDTO.getUid();
        Long comment_onwer = boardCommentMapper.getAccountUid(comment.getUid());

        if (comment_onwer == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD_COMMENT);

        if (comment_onwer != user_uid)
            throw new BaseException(ErrorMessage.NOT_PERMISSION_EXCEPTION);

        comment.setAccountUid(user_uid);

        boardCommentMapper.updateComment(comment);

        return new BaseResponse("댓글 수정에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteComment(Long board_comment_uid) throws Exception {
        AccountDTO servAccountDTO = authService.authUser();


        long user_uid = servAccountDTO.getUid();
        Long comment_onwer = boardCommentMapper.getAccountUid(board_comment_uid);

        if (comment_onwer == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD_COMMENT);

        if (comment_onwer != user_uid)
            throw new BaseException(ErrorMessage.NOT_PERMISSION_EXCEPTION);

        boardCommentMapper.deleteComment(board_comment_uid);
        return new BaseResponse("댓글 삭제에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse createBoardCommentEmotion(Long board_comment_uid, Integer status) throws Exception {
        /**
         * TODO: 중복 예외 처리 필요
         * TODO: 공감 상태 enum 확인 필요
         */
        AccountDTO authVO = authService.authUser();
        if (!boardCommentMapper.isBoardComment(board_comment_uid))
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD_COMMENT);

        long user_uid = authVO.getUid();
        boardCommentMapper.createBoardCommentEmotion(board_comment_uid, user_uid, status);

        return new BaseResponse("공감에 성공하였습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoardCommentEmotion(Long board_comment_uid) throws Exception {
        /**
         * TODO: 없는 것에 대한 취소 시 예외 처리 필요
         */
        AccountDTO authVO = authService.authUser();
        if (!boardCommentMapper.isBoardComment(board_comment_uid))
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD_COMMENT);

        long user_uid = authVO.getUid();

        boardCommentMapper.deleteBoardCommentEmotion(board_comment_uid, user_uid);

        return new BaseResponse("공감에 취소에 성공하였습니다.", HttpStatus.OK);

    }

    @Override
    public List<BoardCommentEmotionDTO> getBoardCommentEmotion(Long board_comment_uid) throws Exception {
        AccountDTO authVO = authService.authUser();
        if (!boardCommentMapper.isBoardComment(board_comment_uid))
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD_COMMENT);

        return boardCommentMapper.getBoardCommentEmotion(board_comment_uid);
    }
}
