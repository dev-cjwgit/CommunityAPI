package repository;

import domain.entity.origin_mapping.StockEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<StockEntity> test();
}
