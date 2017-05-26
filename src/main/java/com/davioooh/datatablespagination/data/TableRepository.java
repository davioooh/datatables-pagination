package com.davioooh.datatablespagination.data;


import com.davioooh.datatablespagination.PaginationCriteria;

import java.util.List;

/**
 * This interface is used to retrieve data to paginate. Classes implementing
 * {@code TablePagerRepository} should also implement filter and ordering logic.
 *
 * @author David Castelletti
 *
 */
public interface TableRepository<T> {

	/**
	 * Used to get the total count of the entries before filtering.
	 * 
	 * @return the total count of the entries.
	 * @throws TableRepositoryException
	 */
	long countTotalEntries() throws TableRepositoryException;

	/**
	 * Used to get the number of total filtered result according to provided
	 * search criteria declared in {@code PaginationCriteria}}
	 * 
	 * @param pCriteria
	 *            pagination criteria.
	 * @return the count of filter entries.
	 * @throws TableRepositoryException
	 */
	long countFilteredEntries(PaginationCriteria pCriteria) throws TableRepositoryException;

	/**
	 * Used to select and filter the entries for a single page. It provides the
	 * entries filtered by search keys and sorted by ordering criteria declared
	 * in {@code PaginationCriteria}}
	 * 
	 * @param pCriteria
	 *            pagination criteria.
	 * @return filter and ordered entities.
	 * @throws TableRepositoryException
	 */
	List<T> findPageEntries(PaginationCriteria pCriteria) throws TableRepositoryException;

}
