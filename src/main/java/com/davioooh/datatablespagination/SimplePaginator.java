package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.data.TableData;
import com.davioooh.datatablespagination.model.request.PaginationCriteria;
import com.davioooh.datatablespagination.model.response.TablePage;

public class SimplePaginator implements TablePaginator {

    private TableData tableData;

    public SimplePaginator(TableData tableData) {
        this.tableData = tableData;
    }

    @Override
    public TablePage getPage(PaginationCriteria paginationCriteria) {
        TablePage page = new TablePage();
        try {
            page = generatePage(paginationCriteria);
        } catch (Exception e) {
            page.setError("Error generating table page: " + e.getMessage());
        }
        return page;
    }

    protected TablePage generatePage(PaginationCriteria paginationCriteria) {
        TablePage page = new TablePage();
        page.setDraw(paginationCriteria.getDraw());
        page.setRecordsTotal(tableData.countTotalEntries());
        page.setRecordsFiltered(tableData.countFilteredEntries(paginationCriteria));
        page.setData(tableData.getPageEntries(paginationCriteria));
        return page;
    }

}
