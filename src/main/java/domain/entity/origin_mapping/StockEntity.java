package domain.entity.origin_mapping;

import java.sql.Timestamp;

public class StockEntity {
    protected String name;
    protected Double open;
    protected Double high;
    protected Double low;
    protected Double close;
    protected Double adj_close;
    protected Long volume;
    protected Timestamp date;


    public String getName() {
        return name;
    }

    public Double getOpen() {
        return open;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public Double getClose() {
        return close;
    }

    public Double getAdj_close() {
        return adj_close;
    }

    public Long getVolume() {
        return volume;
    }

    public Timestamp getDate() {
        return date;
    }
}
