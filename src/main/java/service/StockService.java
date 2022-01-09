package service;

import domain.entity.StockEntity;
import domain.param.StockRequestModel;
import domain.dto.AuthDTO;
import enums.ErrorMessage;
import exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StockMapper;
import service.interfaces.IAuthService;
import service.interfaces.IStockService;

import java.util.List;

@Service
public class StockService implements IStockService {
    @Autowired
    private IAuthService authService;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<StockEntity> getStockList(StockRequestModel model) throws Exception {
        AuthDTO authVO = authService.authUser();

        if (authVO != null) {
            return stockMapper.getStockList(model);
        } else {
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID);
        }
    }
}
