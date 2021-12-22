package repository;

import domain.dto.BoardCommentDTO;
import domain.vo.BoardCommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCommentMapper {
    void createComment(@Param(value = "comment") BoardCommentVO comment);

    List<BoardCommentDTO> getComment(@Param(value = "board_uid") Long board_uid);

    void updateComment(@Param(value = "comment") BoardCommentVO comment);

    void deleteComment(@Param(value = "comment_uid") Long comment_uid);

    Long getAccountUid(@Param(value = "comment_uid") Long comment_uid);
}
