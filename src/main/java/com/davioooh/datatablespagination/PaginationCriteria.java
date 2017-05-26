package com.davioooh.datatablespagination;

import com.google.common.base.Predicate;

import java.util.List;

/**
 * The pagination criteria provided by the client to process and generate a
 * table page. It includes, pagination, ordering and search criteria. An
 * instance of this class can be created directly deserializing the JSON request
 * payload from the client.
 *
 * @author David Castelletti
 *
 */
public class PaginationCriteria {
	private int draw;
	private List<Column> columns;
	private List<OrderingCriteria> order;
	private int start;
	private int length;
	private SearchCriteria search;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<OrderingCriteria> getOrder() {
		return order;
	}

	public void setOrder(List<OrderingCriteria> order) {
		this.order = order;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public SearchCriteria getSearch() {
		return search;
	}

	public void setSearch(SearchCriteria search) {
		this.search = search;
	}

	public static class Column {

		public static final Predicate<Column> IS_SEARCHABLE = new Predicate<PaginationCriteria.Column>() {
			@Override
			public boolean apply(Column input) {
				return input.isSearchable();
			}
		};

		public static final Predicate<Column> IS_ORDERABLE = new Predicate<PaginationCriteria.Column>() {
			@Override
			public boolean apply(Column input) {
				return input.isOrderable();
			}
		};

		private String data;
		private String name;
		private boolean searchable;
		private boolean orderable;
		private SearchCriteria search;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isSearchable() {
			return searchable;
		}

		public void setSearchable(boolean searchable) {
			this.searchable = searchable;
		}

		public boolean isOrderable() {
			return orderable;
		}

		public void setOrderable(boolean orderable) {
			this.orderable = orderable;
		}

		public SearchCriteria getSearch() {
			return search;
		}

		public void setSearch(SearchCriteria search) {
			this.search = search;
		}
	}

	public static class SearchCriteria {
		private String value;
		private boolean regex; // not used

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public boolean isRegex() {
			return regex;
		}

		public void setRegex(boolean regex) {
			this.regex = regex;
		}
	}

	public static class OrderingCriteria {
		public static final String ASC = "asc";
		public static final String DESC = "desc";

		private int column;
		private String dir;

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

		public String getDir() {
			return dir;
		}

		public void setDir(String dir) {
			this.dir = dir;
		}
	}

}
