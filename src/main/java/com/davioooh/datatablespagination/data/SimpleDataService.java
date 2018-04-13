package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class SimpleDataService<T> implements TableDataService {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException {
		List<T> data = getData(paginationCriteria);
		List<Map<String, Object>> records = data.stream().map(i -> objectMapper.convertValue(i, Map.class))
				.collect(Collectors.toList());
		return records.stream()
				.map(m -> m.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> v.toString())))
				.collect(Collectors.toList());
	}

	protected abstract List<T> getData(PaginationCriteria paginationCriteria) throws TableDataException;

}
