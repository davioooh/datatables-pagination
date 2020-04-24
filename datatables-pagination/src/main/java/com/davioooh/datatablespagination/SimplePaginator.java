package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.data.TableDataException;
import com.davioooh.datatablespagination.data.TableDataService;
import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.davioooh.datatablespagination.model.TablePage;

public class SimplePaginator implements TablePaginator {

    private TableDataService dataService;

    public SimplePaginator(TableDataService dataService) {
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
        // FIXME log.debug("Draw set...");

        page.setRecordsTotal(dataService.countTotalEntries());
        // FIXME log.debug("RecordsTotal set...");

        page.setRecordsFiltered(dataService.countFilteredEntries(paginationCriteria));
        // FIXME log.debug("RecordsFiltered set...");

        page.setData(dataService.getPageEntries(paginationCriteria));
        // FIXME log.debug("Data set...");

        return page;
    }

}
