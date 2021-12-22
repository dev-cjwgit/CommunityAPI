package service;

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
}
