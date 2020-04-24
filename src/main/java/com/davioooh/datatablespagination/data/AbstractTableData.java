package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.model.request.PaginationCriteria;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractTableData<T> implements TableData {

    private ObjectMapper objectMapper;

    public AbstractTableData(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        List<T> data = getData(paginationCriteria);

        List<Map<String, String>> records;
        try {
            records = data.stream()
                    .map(entry -> objectMapper.convertValue(entry, new TypeReference<Map<String, String>>() {
                    }))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TableDataException("Error collecting entries.", e);
        }
        return records;
    }

    protected abstract List<T> getData(PaginationCriteria paginationCriteria) throws TableDataException;

}
