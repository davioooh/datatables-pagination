package com.davioooh.datatablespagination;

/**
 * The main component, used to generate a {@code TablePage}} according to {@code PaginationCriteria}.
 *
 * @author David Castelletti
 *
 */
public interface TablePaginator {

	TablePage getPage(PaginationCriteria pCriteria) throws TablePaginationException;

}
