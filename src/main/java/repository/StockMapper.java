package repository;

import domain.dto.StockDTO;
import domain.param.StockRequestModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMapper {
    List<StockDTO> getStockList(@Param("model") StockRequestModel model);

}
