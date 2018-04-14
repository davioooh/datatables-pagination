package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.data.TableDataService;
import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.davioooh.datatablespagination.model.TablePage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimplePaginator implements TablePaginator {

	private TableDataService dataService;

	public SimplePaginator(TableDataService dataService) {
		this.dataService = dataService;
	}

	@Override
	public TablePage getPage(PaginationCriteria paginationCriteria) throws TablePaginationException {
		TablePage page = new TablePage();
		try {
            page.setDraw(paginationCriteria.getDraw());
            log.debug("Draw set...");

            page.setRecordsTotal(dataService.countTotalEntries());
            log.debug("RecordsTotal set...");

            page.setRecordsFiltered(dataService.countFilteredEntries(paginationCriteria));
            log.debug("RecordsFiltered set...");

            page.setData(dataService.getPageEntries(paginationCriteria));
            log.debug("Data set...");
        }
        catch (Exception e){
		    log.error("Error generating table page.", e);
		    throw new TablePaginationException("", e);
        }
		return page;
	}
}
