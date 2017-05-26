package com.davioooh.datatablespagination;

import java.util.List;
import java.util.Map;

/**
 * This class represents the result of the server-side pagination. Its JSON
 * serialization can be privided to the client as table data structure.
 *
 * @author David Castelletti
 *
 */
public class TablePage {
	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<Map<String, String>> data;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<Map<String, String>> getData() {
		return data;
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}

}
