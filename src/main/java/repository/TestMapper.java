package repository;

import domain.entity.StockDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<StockDTO> test();
}
