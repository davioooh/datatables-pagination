package com.davioooh.datatablespagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderingCriteria {
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	private int column;
	private String dir;

}