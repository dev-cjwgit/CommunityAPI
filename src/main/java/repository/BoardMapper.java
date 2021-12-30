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

    List<BoardDTO> getSummaryBoardList(@Param(value = "page") int page, @Param(value = "range") int range);

    BoardDTO getBoardInfo(@Param(value = "board_uid") Long board_uid);

    void updateBoard(@Param(value = "board") BoardVO board);

    void deleteBoard(@Param(value = "board_uid") Long board_uid);

    Long getAccountUid(@Param(value = "board_uid") Long board_uid);

    Long getBoardListCnt();
}
