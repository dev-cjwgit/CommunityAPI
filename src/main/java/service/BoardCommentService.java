package service;

import domain.dto.BoardCommentDTO;
import domain.dto.BoardDTO;
import domain.vo.BoardCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.BoardCommentMapper;
import repository.BoardMapper;
import response.BaseResponse;
import service.interfaces.IBoardCommentService;
import util.Jwt;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@Service
public class BoardCommentService implements IBoardCommentService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardCommentMapper boardCommentMapper;

    @Autowired
    private Jwt jwt;


    @Override
    public BaseResponse createComment(BoardCommentVO comment) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

        BoardDTO board = boardMapper.getBoardInfo(comment.getBoard_uid());

        if (board == null)
            throw new Exception("존재하지 않는 게시글입니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());

        comment.setAccount_uid(user_uid);

        boardCommentMapper.createComment(comment);

        return new BaseResponse("댓글 등록에 성공했습니다.", HttpStatus.OK);

    }

    @Override
    public List<BoardCommentDTO> getComment(Long board_uid) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

        BoardDTO board = boardMapper.getBoardInfo(board_uid);

        if (board == null)
            throw new Exception("존재하지 않는 게시글입니다.");

        return boardCommentMapper.getComment(board_uid);
    }

    @Override
    public BaseResponse updateComment(BoardCommentVO comment) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());
        Long comment_onwer = boardCommentMapper.getAccountUid(comment.getUid());

        if (comment_onwer == null)
            throw new Exception("댓글 고유번호가 잘못되었습니다.");

        if (comment_onwer != user_uid)
            throw new Exception("댓글을 수정 할 권한이 없습니다.");

        comment.setAccount_uid(user_uid);

        boardCommentMapper.updateComment(comment);

        return new BaseResponse("댓글 수정에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteComment(Long board_comment_uid) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());
        Long comment_onwer = boardCommentMapper.getAccountUid(board_comment_uid);

        if (comment_onwer == null)
            throw new Exception("댓글 고유번호가 잘못되었습니다.");

        if (comment_onwer != user_uid)
            throw new Exception("댓글을 삭제 할 권한이 없습니다.");

        boardCommentMapper.deleteComment(board_comment_uid);
        return new BaseResponse("댓글 삭제에 성공했습니다.", HttpStatus.OK);
    }
}
