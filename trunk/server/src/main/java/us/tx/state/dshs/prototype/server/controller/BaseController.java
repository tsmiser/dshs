package us.tx.state.dshs.prototype.server.controller;

import us.tx.state.dshs.prototype.server.model.DataTable;

import java.util.Collection;

public class BaseController {
    public DataTable convertToDataTable(Collection collection) {
        DataTable dataTable = new DataTable();
        dataTable.setRecordsTotal(collection.size());
        dataTable.setRecordFiltered(collection.size());
        dataTable.setData(collection.toArray());
        return dataTable;
    }
}
