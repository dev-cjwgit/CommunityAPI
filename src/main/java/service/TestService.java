package service;

import domain.dto.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TestMapper;
import service.interfaces.ITestService;

import java.util.List;

@Service
public class TestService implements ITestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<StockDTO> test1() throws Exception {
        return testMapper.test();
    }
}
