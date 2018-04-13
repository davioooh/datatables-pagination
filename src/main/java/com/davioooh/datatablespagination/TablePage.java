package com.davioooh.datatablespagination;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the result of the server-side pagination. Its JSON
 * serialization can be privided to the client as table data structure.
 *
 * @author David Castelletti
 *
 */
@Getter
@Setter
public class TablePage {
	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<Map<String, String>> data;

}
