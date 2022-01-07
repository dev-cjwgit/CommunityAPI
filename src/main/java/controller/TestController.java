package controller;

import domain.param.StockRequestModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.interfaces.ITestService;

@Controller
public class TestController {
    @Autowired
    private ITestService testService;

    @ResponseBody
    @RequestMapping(value = "/testpage", method = RequestMethod.GET)
    @ApiOperation(value = "테스트1", notes = "테스트1 입니다.")
    public ResponseEntity test1() throws Exception {
        return new ResponseEntity(testService.test1(), HttpStatus.OK);
    }
}
