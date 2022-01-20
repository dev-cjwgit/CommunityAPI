package repository;

import domain.dto.StockDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<StockDTO> test();
}
