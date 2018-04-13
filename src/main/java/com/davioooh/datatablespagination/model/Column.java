package com.davioooh.datatablespagination.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Column {

	/**
	 * Column's data source.
	 */
	private String data;

	/**
	 * Column's name.
	 */
	private String name;

	/**
	 * Flag to indicate if this column is searchable (true) or not (false).
	 */
	private boolean searchable;

	/**
	 * Flag to indicate if this column is orderable (true) or not (false).
	 */
	private boolean orderable;

	/**
	 * Search criteria to apply to this specific column.
	 */
	private SearchCriteria search;

}