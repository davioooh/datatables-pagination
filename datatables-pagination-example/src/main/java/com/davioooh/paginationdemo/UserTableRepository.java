package com.davioooh.paginationdemo;

import com.davioooh.datatablespagination.data.DataServiceBase;
import com.davioooh.datatablespagination.data.TableDataException;
import com.davioooh.datatablespagination.model.PaginationCriteria;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserTableRepository extends DataServiceBase<User> {

	private static final List<User> TEST_DATA = Arrays.asList(new User(1, "Lisa", 20), new User(2, "Tom", 31),
			new User(3, "David", 38), new User(4, "Marco", 23), new User(5, "Jenny", 15));

	@Override
	public long countTotalEntries() throws TableDataException {
		return TEST_DATA.size();
	}

	@Override
	public long countFilteredEntries(PaginationCriteria paginationCriteria) throws TableDataException {
		return 0;
	}

	@Override
	protected List<User> getData(PaginationCriteria paginationCriteria) throws TableDataException {
		return TEST_DATA.stream().filter(u->u.getName().contains(paginationCriteria.getSearch().getValue())).collect(Collectors.toList());
	}

}