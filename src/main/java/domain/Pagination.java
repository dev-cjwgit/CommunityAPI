package domain;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Pagination {
    @ApiParam(defaultValue = "2")
    private Integer page = 2;
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