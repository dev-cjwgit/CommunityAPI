package service;

import domain.dto.BoardCommentDTO;
import domain.dto.BoardDTO;
import domain.vo.AuthVO;
import domain.vo.BoardCommentVO;
import enums.ErrorMessage;
import exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.BoardCommentMapper;
import repository.BoardMapper;
import response.BaseResponse;
import service.interfaces.IAuthService;
import service.interfaces.IBoardCommentService;
import util.Jwt;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

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
    public BaseResponse createComment(BoardCommentVO comment) throws Exception {
        AuthVO authVO = authService.authUser();

        BoardDTO board = boardMapper.getBoardInfo(comment.getBoard_uid());

        if (board == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD);

        long user_uid = authVO.getUid();

        comment.setAccount_uid(user_uid);

        boardCommentMapper.createComment(comment);

        return new BaseResponse("댓글 등록에 성공했습니다.", HttpStatus.OK);

    }

    @Override
    public List<BoardCommentDTO> getComment(Long board_uid, int page, int range) throws Exception {
        AuthVO authVO = authService.authUser();

        BoardDTO board = boardMapper.getBoardInfo(board_uid);

        if (board == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD);

        page = (page - 1) * range;
        return boardCommentMapper.getComment(board_uid, page, range);
    }

    @Override
    public BaseResponse updateComment(BoardCommentVO comment) throws Exception {
        AuthVO authVO = authService.authUser();

        long user_uid = authVO.getUid();
        Long comment_onwer = boardCommentMapper.getAccountUid(comment.getUid());

        if (comment_onwer == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD_COMMENT);

        if (comment_onwer != user_uid)
            throw new BaseException(ErrorMessage.PERMISSION_EXCEPTION);

        comment.setAccount_uid(user_uid);

        boardCommentMapper.updateComment(comment);

        return new BaseResponse("댓글 수정에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteComment(Long board_comment_uid) throws Exception {
        AuthVO authVO = authService.authUser();


        long user_uid = authVO.getUid();
        Long comment_onwer = boardCommentMapper.getAccountUid(board_comment_uid);

        if (comment_onwer == null)
            throw new BaseException(ErrorMessage.NOT_EXIST_BOARD_COMMENT);

        if (comment_onwer != user_uid)
            throw new BaseException(ErrorMessage.PERMISSION_EXCEPTION);

        boardCommentMapper.deleteComment(board_comment_uid);
        return new BaseResponse("댓글 삭제에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse createBoardCommentEmotion(Long board_comment_uid, Integer status) throws Exception {
        /**
         * TODO: 댓글 고유번호 확인 필요
         * TODO: 중복 예외 처리 필요
         * TODO: 공감 상태 enum 확인 필요
         */
        AuthVO authVO = authService.authUser();

        long user_uid = authVO.getUid();
        boardCommentMapper.createBoardCommentEmotion(board_comment_uid, user_uid, status);

        return new BaseResponse("공감에 성공하였습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoardCommentEmotion(Long board_comment_uid) throws Exception {
        /**
         * TODO: 댓글 고유번호 확인 필요
         * TODO: 없는 것에 대한 취소 시 예외 처리 필요
         */
        AuthVO authVO = authService.authUser();

        long user_uid = authVO.getUid();

        boardCommentMapper.deleteBoardCommentEmotion(board_comment_uid, user_uid);

        return new BaseResponse("공감에 취소에 성공하였습니다.", HttpStatus.OK);

    }

    @Override
    public Integer getBoardCommentEmotion(Long board_comment_uid) throws Exception {
        AuthVO authVO = authService.authUser();

        return boardCommentMapper.getBoardCommentEmotion(board_comment_uid);
    }
}
