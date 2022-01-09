package repository;

import domain.entity.origin_mapping.StockEntity;
import domain.param.StockRequestModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMapper {
    List<StockEntity> getStockList(@Param("model") StockRequestModel model);

}
