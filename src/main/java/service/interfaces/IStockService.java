package service.interfaces;

import domain.dto.StockDTO;
import domain.param.StockRequestModel;

import java.util.List;

public interface IStockService {
    List<StockDTO> getStockList(StockRequestModel model) throws Exception;

}
