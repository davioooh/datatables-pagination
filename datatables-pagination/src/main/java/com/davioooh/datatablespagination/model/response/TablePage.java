package com.davioooh.datatablespagination.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;
import java.util.Map;

/**
 * Class representing the result of the server-side pagination. Its JSON
 * serialization can be privided to the client as table data structure.
 *
 * @author David Castelletti
 */
public class TablePage {

    /**
     * The draw counter that this object is a response to - from the draw parameter
     * sent as part of the data request.
     */
    private int draw;

    /**
     * Total records, before filtering.
     */
    private long recordsTotal;

    /**
     * Total records, after filtering (i.e. the total number of records after
     * filtering has been applied - not just the number of records being returned
     * for this page of data).
     */
    private long recordsFiltered;

    /**
     * The data to be displayed in the table. This is an array of data source
     * objects, one for each row, which will be used by DataTables.
     */
    private List<Map<String, String>> data;

    /**
     * If an error occurs during the running of the server-side processing script,
     * you can inform the user of this error by passing back the error message to be
     * displayed using this parameter. Do not include if there is no error.
     */
    @JsonInclude(Include.NON_EMPTY)
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
