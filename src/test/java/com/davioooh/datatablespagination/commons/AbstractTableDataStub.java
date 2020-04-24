package com.davioooh.datatablespagination.commons;

import com.davioooh.datatablespagination.data.AbstractTableData;
import com.davioooh.datatablespagination.data.TableDataException;
import com.davioooh.datatablespagination.model.request.PaginationCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class AbstractTableDataStub extends AbstractTableData<User> {

    public static final List<User> TEST_DATA =
            Arrays.asList(
                    new User(1, "Lisa", 20),
                    new User(2, "Tom", 31),
                    new User(3, "David", 38),
                    new User(4, "Marco", 23),
                    new User(5, "Jenny", 15));

    public AbstractTableDataStub(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public long countTotalEntries() throws TableDataException {
        throw new UnsupportedOperationException();
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected List<User> getData(PaginationCriteria paginationCriteria) throws TableDataException {
        return TEST_DATA;
    }
}