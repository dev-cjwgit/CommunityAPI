package domain.param;

import annotation.ValidationGroups;
import domain.Pagination;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class BoardSearchModel extends Pagination {
    @Size(min = 2, groups = {ValidationGroups.searchBoard.class}, message = "제목은 최소 2글자 이상으로 검색해야 합니다.")
    private String title;
    @Size(min = 2, groups = {ValidationGroups.searchBoard.class}, message = "닉네임은 최소 2글자 이상으로 검색해야 합니다.")
    private String nickname;
    @Size(min = 2, groups = {ValidationGroups.searchBoard.class}, message = "글 내용은 최소 2글자 이상으로 검색해야 합니다.")
    private String body;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
