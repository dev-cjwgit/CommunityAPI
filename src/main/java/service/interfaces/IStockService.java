package service.interfaces;

import domain.entity.StockEntity;
import domain.param.StockRequestModel;

import java.util.List;

public interface IStockService {
    List<StockEntity> getStockList(StockRequestModel model) throws Exception;

}
