package domain;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class Pagination {
    @ApiParam(defaultValue = "1")
    private Integer page = 1;
    @ApiModelProperty(hidden = true)
    private Integer endPage;
    @ApiParam(defaultValue = "10")
    private Integer range = 10;

    public Integer getPage() {
        return page = (page - 1) * range;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }
}