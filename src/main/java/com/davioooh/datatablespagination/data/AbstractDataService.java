package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractDataService<T> implements TableDataService {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        List<T> data = getData(paginationCriteria);
        List<Map<String, String>> records = new ArrayList<>(data.size());
        data.forEach(i -> {
            Map<String, Object> m = objectMapper.convertValue(i, Map.class);
            records.add(m.entrySet().stream()
                    .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));
        });

        return records;
    }

    protected abstract List<T> getData(PaginationCriteria paginationCriteria) throws TableDataException;

}
