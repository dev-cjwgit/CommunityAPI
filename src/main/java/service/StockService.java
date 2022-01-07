package service;

import domain.dto.StockDTO;
import domain.param.StockRequestModel;
import domain.vo.AuthVO;
import enums.ErrorMessage;
import exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.StockMapper;
import service.interfaces.IAccountService;
import service.interfaces.IAuthService;
import service.interfaces.IStockService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class StockService implements IStockService {
    @Autowired
    private IAuthService authService;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<StockDTO> getStockList(StockRequestModel model) throws Exception {
        AuthVO authVO = authService.authUser();

        if (authVO != null) {
            return stockMapper.getStockList(model);
        } else {
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID);
        }
    }
}
