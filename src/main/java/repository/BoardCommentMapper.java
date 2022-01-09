package repository;

import domain.entity.BoardCommentDTO;
import domain.vo.BoardCommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCommentMapper {
    void createComment(@Param(value = "comment") BoardCommentVO comment);

    List<BoardCommentDTO> getComment(@Param(value = "board_uid") Long board_uid, @Param(value = "page") int page, @Param(value = "range") int range);

    void updateComment(@Param(value = "comment") BoardCommentVO comment);

    void deleteComment(@Param(value = "comment_uid") Long comment_uid);

    Long getAccountUid(@Param(value = "comment_uid") Long comment_uid);

    void createBoardCommentEmotion(@Param(value = "board_comment_uid") Long board_uid, @Param(value = "account_uid") Long account_uid, @Param(value = "status") Integer status);

    void deleteBoardCommentEmotion(@Param(value = "board_comment_uid") Long board_uid, @Param(value = "account_uid") Long account_uid);

    Integer getBoardCommentEmotion(@Param(value = "board_comment_uid") Long board_uid);
}
