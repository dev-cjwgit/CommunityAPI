package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BoardCommentMapper;
import repository.BoardMapper;
import service.interfaces.IBoardCommentService;
import util.Jwt;

@Service
public class BoardCommentService implements IBoardCommentService {
    @Autowired
    private BoardCommentMapper boardCommentMapper;

    @Autowired
    private Jwt jwt;


}
