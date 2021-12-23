package service;

import domain.dto.BoardDTO;
import domain.vo.AccountRegisterVO;
import domain.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.AccountMapper;
import repository.BoardMapper;
import response.BaseResponse;
import service.interfaces.IBoardService;
import util.Jwt;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class BoardService implements IBoardService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private Jwt jwt;

    @Override
    public BaseResponse createBoard(BoardVO board) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

        boardMapper.createBoard(Long.parseLong(data.get("uid").toString()), board);

        return new BaseResponse("게시글 등록에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public List<BoardDTO> getSummaryBoardList() throws Exception {
        return boardMapper.getSummaryBoardList();
    }

    @Override
    public BoardDTO getBoardInfo(Long board_uid) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

//        long user_uid = Long.parseLong(data.get("uid").toString());
        Long board_onwer = boardMapper.getAccountUid(board_uid);

        if (board_onwer == null)
            throw new Exception("게시글 고유번호가 잘못되었습니다.");

        return boardMapper.getBoardInfo(board_uid);
    }

    @Override
    public BaseResponse updateBoard(BoardVO board) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());
        Long board_onwer = boardMapper.getAccountUid(board.getUid());

        if (board_onwer == null)
            throw new Exception("게시글 고유번호가 잘못되었습니다.");

        if (board_onwer != user_uid)
            throw new Exception("게시물을 삭제 할 권한이 없습니다.");

        boardMapper.updateBoard(board);

        return new BaseResponse("게시글 수정에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoard(Long board_uid) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null)
            throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());
        Long board_onwer = boardMapper.getAccountUid(board_uid);

        if (board_onwer == null)
            throw new Exception("서버에 오류가 발생하였습니다.");


        if (board_onwer != user_uid)
            throw new Exception("게시물을 삭제 할 권한이 없습니다.");

        boardMapper.deleteBoard(board_uid);

        return new BaseResponse("게시글 삭제에 성공했습니다.", HttpStatus.OK);

    }
}
