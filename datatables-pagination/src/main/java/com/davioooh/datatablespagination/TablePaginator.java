package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.davioooh.datatablespagination.model.TablePage;

/**
 * The main component, used to generate a {@link TablePage}} according to
 * {@link PaginationCriteria}.
 *
 * @author David Castelletti
 */
public interface TablePaginator {
    TablePage getPage(PaginationCriteria paginationCriteria);
}
