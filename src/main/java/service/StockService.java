package service;

import domain.dto.StockDTO;
import domain.param.StockRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.StockMapper;
import service.interfaces.IStockService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class StockService implements IStockService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<StockDTO> getStockList(StockRequestModel model) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        Map<String, Object> user_data = accountService.checkKey(token);
        if (user_data != null) {
            return stockMapper.getStockList(model);
        } else {
            throw new Exception("유효하지 않은 토큰입니다.");
        }
    }
}
