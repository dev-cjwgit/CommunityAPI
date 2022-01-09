package service;

import domain.entity.origin_mapping.StockEntity;
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
    public List<StockEntity> test1() throws Exception {
        return testMapper.test();
    }
}
