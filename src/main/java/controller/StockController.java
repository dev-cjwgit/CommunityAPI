package controller;

import domain.param.StockRequestModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.interfaces.IStockService;

@Controller
public class StockController {
    @Autowired
    private IStockService stockService;

    @ResponseBody
    @RequestMapping(value = "/stock", method = RequestMethod.GET)
    @ApiOperation(value = "주식 정보", notes = "주식 정보를 가져옵니다. {종목이름, 정렬타입, 시작날짜, 마지막날짜}")
    public ResponseEntity stock(StockRequestModel model) throws Exception {
        return new ResponseEntity(stockService.getStockList(model), HttpStatus.OK);
    }
}
