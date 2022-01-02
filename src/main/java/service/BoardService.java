package service;

import domain.dto.BoardDTO;
import domain.vo.AccountRegisterVO;
import domain.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    /**
     * TODO: request 토큰 확인 코드 중복 제거 필요
     * TODO: jwt.verifyJWT Map이 아닌 별도 도메인 객체로 맵핑 하는 것이 좋음
     */
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
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");

        boardMapper.createBoard(Long.parseLong(data.get("uid").toString()), board);

        return new BaseResponse("게시글 등록에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public List<BoardDTO> getSummaryBoardList(int page, int range) throws Exception {
        page = (page - 1) * range;
        return boardMapper.getSummaryBoardList(page, range);
    }

    @Override
    public BoardDTO getBoardInfo(Long board_uid) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");

//        long user_uid = Long.parseLong(data.get("uid").toString());
        Long board_onwer = boardMapper.getAccountUid(board_uid);

        if (board_onwer == null) throw new Exception("게시글 고유번호가 잘못되었습니다.");

        return boardMapper.getBoardInfo(board_uid);
    }

    @Override
    public BaseResponse updateBoard(BoardVO board) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());
        Long board_onwer = boardMapper.getAccountUid(board.getUid());

        if (board_onwer == null) throw new Exception("게시글 고유번호가 잘못되었습니다.");

        if (board_onwer != user_uid) throw new Exception("게시물을 삭제 할 권한이 없습니다.");

        boardMapper.updateBoard(board);

        return new BaseResponse("게시글 수정에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoard(Long board_uid) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());
        Long board_onwer = boardMapper.getAccountUid(board_uid);

        if (board_onwer == null) throw new Exception("서버에 오류가 발생하였습니다.");


        if (board_onwer != user_uid) throw new Exception("게시물을 삭제 할 권한이 없습니다.");

        boardMapper.deleteBoard(board_uid);

        return new BaseResponse("게시글 삭제에 성공했습니다.", HttpStatus.OK);

    }

    @Override
    public Long getBoardListCnt() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");

        return boardMapper.getBoardListCnt();
    }

    @Override
    public BaseResponse createBoardEmotion(Long board_uid, Integer status) throws Exception {
        /**
         * TODO: 게시판 고유번호 확인 필요
         * TODO: 중복 예외 처리 필요
         * TODO: 공감 상태 enum 확인 필요
         */
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());
        boardMapper.createBoardEmotion(board_uid, user_uid, status);

        return new BaseResponse("공감에 성공하였습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoardEmotion(Long board_uid) throws Exception {
        /**
         * TODO: 게시판 고유번호 확인 필요
         * TODO: 없는 것에 대한 취소 시 예외 처리 필요
         */
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");

        long user_uid = Long.parseLong(data.get("uid").toString());

        boardMapper.deleteBoardEmotion(board_uid, user_uid);

        return new BaseResponse("공감에 취소에 성공하였습니다.", HttpStatus.OK);

    }

    @Override
    public Integer getBoardEmotion(Long board_uid) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> data = jwt.verifyJWT(token);
        if (data == null) throw new Exception("토큰이 잘못되었습니다.");


        return boardMapper.getBoardEmotion(board_uid);
    }
}
