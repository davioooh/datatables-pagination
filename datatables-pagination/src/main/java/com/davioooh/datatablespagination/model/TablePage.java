package com.davioooh.datatablespagination.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Class representing the result of the server-side pagination. Its JSON
 * serialization can be privided to the client as table data structure.
 *
 * @author David Castelletti
 *
 */
@Getter
@Setter
public class TablePage {

	/**
	 * The draw counter that this object is a response to - from the draw parameter
	 * sent as part of the data request.
	 */
	private int draw;

	/**
	 * Total records, before filtering.
	 */
	private long recordsTotal;

	/**
	 * Total records, after filtering (i.e. the total number of records after
	 * filtering has been applied - not just the number of records being returned
	 * for this page of data).
	 */
	private long recordsFiltered;

	/**
	 * The data to be displayed in the table. This is an array of data source
	 * objects, one for each row, which will be used by DataTables.
	 */
	private List<Map<String, String>> data;

	/**
	 * If an error occurs during the running of the server-side processing script,
	 * you can inform the user of this error by passing back the error message to be
	 * displayed using this parameter. Do not include if there is no error.
	 */
	@JsonInclude(Include.NON_EMPTY)
	private String error;

}
