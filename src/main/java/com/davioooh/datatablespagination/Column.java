package com.davioooh.datatablespagination;

import com.google.common.base.Predicate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Column {

	public static final Predicate<Column> IS_SEARCHABLE = new Predicate<Column>() {
		@Override
		public boolean apply(Column input) {
			return input.isSearchable();
		}
	};

	public static final Predicate<Column> IS_ORDERABLE = new Predicate<Column>() {
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

}