package com.davioooh.datatablespagination.commons;

import com.davioooh.datatablespagination.data.TableData;
import com.davioooh.datatablespagination.data.TableDataException;
import com.davioooh.datatablespagination.model.request.PaginationCriteria;

import java.util.List;
import java.util.Map;

public class ErrorTableDataStub implements TableData {

    @Override
    public long countTotalEntries() throws TableDataException {
        throw new RuntimeException("countTotalEntries error");
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        throw new RuntimeException("countFilteredEntries error");
    }

    @Override
    public List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        throw new RuntimeException("getPageEntries error");
    }
}
