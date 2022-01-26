package repository;

import com.sun.org.apache.xpath.internal.operations.Bool;
import domain.dto.BoardEmotionDTO;
import domain.dto.BoardDTO;
import domain.dto.BoardViewDTO;
import domain.param.BoardSearchModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    void createBoard(@Param(value = "uid") Long uid, @Param(value = "board") BoardDTO board);

    BoardDTO getBoard(@Param(value = "board_uid") Long board_uid);

    List<BoardDTO> getBoardSummaryList(@Param(value = "board") BoardSearchModel board);

    BoardViewDTO getBoardView(@Param(value = "board_uid") Long board_uid, @Param(value = "account_uid") Long account_uid);

    void updateView(@Param(value = "board_uid") Long board_uid, @Param(value = "account_uid") Long account_uid);

    void appendView(@Param(value = "board_uid") Long board_uid, @Param(value = "account_uid") Long account_uid);

    void updateBoard(@Param(value = "board") BoardDTO board);

    void deleteBoard(@Param(value = "board_uid") Long board_uid);

    Long getAccountUid(@Param(value = "board_uid") Long board_uid);

    Long getBoardListCnt();

    void createBoardEmotion(@Param(value = "board_uid") Long board_uid, @Param(value = "account_uid") Long account_uid, @Param(value = "status") Integer status);

    void deleteBoardEmotion(@Param(value = "board_uid") Long board_uid, @Param(value = "account_uid") Long account_uid);

    List<BoardEmotionDTO> getBoardEmotion(@Param(value = "board_uid") Long board_uid);

    Boolean isBoard(@Param(value = "board_uid") Long board_uid);
}
