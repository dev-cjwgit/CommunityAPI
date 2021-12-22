package controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "테스트 페이지", notes = "테스트 페이지입니다.")
    public String test() {
        return "test";
    }


}
