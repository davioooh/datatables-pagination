package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.data.TableDataService;
import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.davioooh.datatablespagination.model.TablePage;

public class SimplePaginator implements TablePaginator {

	private TableDataService dataService;

	public SimplePaginator(TableDataService dataService) {
		this.dataService = dataService;
	}

	@Override
	public TablePage getPage(PaginationCriteria paginationCriteria) throws TablePaginationException {
		TablePage page = new TablePage();
		page.setDraw(paginationCriteria.getDraw());
		page.setRecordsTotal(dataService.countTotalEntries());
		page.setRecordsFiltered(dataService.countFilteredEntries(paginationCriteria));
		page.setData(dataService.getPageEntries(paginationCriteria));
		return page;
	}
}
