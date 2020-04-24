package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.model.request.PaginationCriteria;

import java.util.List;
import java.util.Map;

/**
 * This interface defines the API to fetch entries to be paginated. Classes
 * implementing {@link TableData} should also implement filtering and
 * ordering logic.
 *
 * @author David Castelletti
 */
public interface TableData {

    /**
     * Returns the total count of the table entries (before filtering).
     *
     * @return the total count of the entries.
     * @throws TableDataException
     */
    long countTotalEntries() throws TableDataException;

    /**
     * Returns the number of total filtered results, according to provided search
     * criteria in {@code PaginationCriteria}}
     *
     * @param paginationCriteria pagination criteria.
     * @return the count of filtered entries.
     * @throws TableDataException
     */
    long countFilteredEntries(PaginationCriteria paginationCriteria) throws TableDataException;

    /**
     * Returns entries for a table page. It should filter entries by search keys and
     * sort them by ordering criteria declared in {@code PaginationCriteria}}
     *
     * @param paginationCriteria pagination criteria.
     * @return filtered and sorted entities for a certain page.
     * @throws TableDataException
     */
    List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException;

}
