package repository;

import domain.dto.BoardDTO;
import domain.vo.AccountRegisterVO;
import domain.vo.BoardVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    void createBoard(@Param(value = "uid") Long uid, @Param(value = "board") BoardVO board);

    List<BoardDTO> getSummaryBoardList();

    BoardDTO getBoardList(@Param(value = "board_uid") int board_uid);

    void updateBoard(@Param(value = "uid") Long uid, @Param(value = "board") BoardVO board);

    void deleteBoard(@Param(value = "board_uid") int board_uid);

}
