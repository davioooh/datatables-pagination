package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.data.TableData;
import com.davioooh.datatablespagination.data.TableDataException;
import com.davioooh.datatablespagination.model.request.PaginationCriteria;
import com.davioooh.datatablespagination.model.response.TablePage;

public class SimplePaginator implements TablePaginator {

    private TableData dataService;

    public SimplePaginator(TableData dataService) {
        this.dataService = dataService;
    }

    @Override
    public TablePage getPage(PaginationCriteria paginationCriteria) {
        TablePage page = new TablePage();
        try {
            page = generatePage(paginationCriteria);
        } catch (TableDataException tde) {
            // FIXME log.error("Error generating table page.", tde);
            page.setError("Error generating table page.");
        }
        return page;
    }

    protected TablePage generatePage(PaginationCriteria paginationCriteria) throws TableDataException {
        TablePage page = new TablePage();
        page.setDraw(paginationCriteria.getDraw());
        page.setRecordsTotal(dataService.countTotalEntries());
        page.setRecordsFiltered(dataService.countFilteredEntries(paginationCriteria));
        page.setData(dataService.getPageEntries(paginationCriteria));
        return page;
    }

}
