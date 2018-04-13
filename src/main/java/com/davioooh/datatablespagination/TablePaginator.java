package com.davioooh.datatablespagination;

/**
 * The main component, used to generate a {@link TablePage}} according to
 * {@link PaginationCriteria}.
 *
 * @author David Castelletti
 *
 */
public interface TablePaginator {
	TablePage getPage(PaginationCriteria paginationCriteria) throws TablePaginationException;
}
