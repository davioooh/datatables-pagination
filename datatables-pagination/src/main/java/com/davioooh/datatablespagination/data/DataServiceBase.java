package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public abstract class DataServiceBase<T> implements TableDataService {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        List<T> data = getData(paginationCriteria);
        log.debug("Table data retrieved...");

        List<Map<String, String>> records = new ArrayList<>(data.size());
        try {
            data.forEach(i -> {
                Map<String, Object> m = objectMapper.convertValue(i, Map.class);
                records.add(m.entrySet().stream()
                        .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));
            });
            log.debug("Data map generated...");
        } catch (Exception e) {
            log.error("Error fetching page entries.", e);
            throw new TableDataException("", e);
        }
        return records;
    }

    protected abstract List<T> getData(PaginationCriteria paginationCriteria) throws TableDataException;

}
