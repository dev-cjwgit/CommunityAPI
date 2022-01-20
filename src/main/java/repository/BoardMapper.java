package repository;

import domain.dto.BoardEmotionDTO;
import domain.dto.BoardDTO;
import domain.dto.BoardSummaryDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    void createBoard(@Param(value = "uid") Long uid, @Param(value = "board") BoardDTO board);

    List<BoardSummaryDTO> searchSummaryBoardTitleBody(@Param(value = "title") String title, @Param(value = "body") String body, @Param(value = "page") int page, @Param(value = "range") int range);

    List<BoardSummaryDTO> searchSummaryBoardNickName(@Param(value = "nickname") String nickname, @Param(value = "page") int page, @Param(value = "range") int range);

    List<BoardSummaryDTO> searchSummaryBoardCommentNickName(@Param(value = "nickname") String nickname, @Param(value = "page") int page, @Param(value = "range") int range);

    List<BoardSummaryDTO> getSummaryBoardList(@Param(value = "page") int page, @Param(value = "range") int range);

    BoardDTO getBoardInfo(@Param(value = "board_uid") Long board_uid);

    void updateBoard(@Param(value = "board") BoardDTO board);

    void deleteBoard(@Param(value = "board_uid") Long board_uid);

    Long getAccountUid(@Param(value = "board_uid") Long board_uid);

    Long getBoardListCnt();

    void createBoardEmotion(@Param(value = "board_uid") Long board_uid, @Param(value = "account_uid") Long account_uid, @Param(value = "status") Integer status);

    void deleteBoardEmotion(@Param(value = "board_uid") Long board_uid, @Param(value = "account_uid") Long account_uid);

    List<BoardEmotionDTO> getBoardEmotion(@Param(value = "board_uid") Long board_uid);

    Boolean isBoard(@Param(value = "board_uid") Long board_uid);
}
