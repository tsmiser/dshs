package us.tx.state.dshs.prototype.server.model;

import java.io.Serializable;

public class DataTable implements Serializable {
    protected Integer draw = 1;
    protected Integer recordsTotal = 0;
    protected Integer recordFiltered = 0;
    protected Object[] data;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordFiltered() {
        return recordFiltered;
    }

    public void setRecordFiltered(Integer recordFiltered) {
        this.recordFiltered = recordFiltered;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
