package com.davioooh.datatablespagination;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * The pagination criteria provided by the client to process and generate a
 * table page. It includes, pagination, ordering and search criteria. An
 * instance of this class can be created directly deserializing the JSON request
 * payload from the client.
 *
 * @author David Castelletti
 *
 */
@Getter
@Setter
public class PaginationCriteria {
	private int draw;
	private List<Column> columns;
	private List<OrderingCriteria> order;
	private int start;
	private int length;
	private SearchCriteria search;

}
