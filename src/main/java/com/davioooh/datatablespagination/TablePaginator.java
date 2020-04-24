package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.model.request.PaginationCriteria;
import com.davioooh.datatablespagination.model.response.TablePage;

/**
 * The main component, used to generate a {@link TablePage} according to
 * {@link PaginationCriteria}.
 *
 * @author David Castelletti
 */
public interface TablePaginator {
    TablePage getPage(PaginationCriteria paginationCriteria);
}
