package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.data.TableDataService;
import com.davioooh.datatablespagination.formatters.BaseFieldFormatter;
import com.davioooh.datatablespagination.formatters.FieldFormatter;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Abstract and generic implementation of {@link TablePaginator}. Provides basic
 * logic to process pagination criteria and to generate a data page structure
 * compliant to DataTables plugin specs.
 *
 * @author David Castelletti
 *
 */
public abstract class AbstractTablePaginator<T> implements TablePaginator {

	private static final FieldFormatter BASE_FORMATTER = new BaseFieldFormatter();

	private TableDataService<T> dataService;
	private TypeToken<T> entityType;
	private Map<String, FieldFormatter> fieldFormatters;

	@SuppressWarnings("serial")
	public AbstractTablePaginator(TableDataService<T> dataService) {
		this.dataService = dataService;
		this.entityType = new TypeToken<T>(getClass()) {
		};
		this.fieldFormatters = new HashMap<>();
	}

	@Override
	public TablePage getPage(PaginationCriteria pCriteria) throws TablePaginationException {
		TablePage tPage = new TablePage();
		tPage.setDraw(pCriteria.getDraw());
		tPage.setRecordsTotal(dataService.countTotalEntries());
		List<T> entries = dataService.findPageEntries(pCriteria);
		tPage.setRecordsFiltered(entries.size());
		tPage.setData(formatOutputData(pCriteria.getColumns(), entries));
		return tPage;
	}

	public void setFieldFormatter(String field, FieldFormatter formatter) {
		fieldFormatters.put(field, formatter);
	}

	public FieldFormatter getFieldFormatter(String field) {
		return fieldFormatters.get(field);
	}

	//

	/**
	 * Converts retrieved data in plain tabular format.
	 * 
	 * @param columns columns declared in pagination criteria.
	 * @param data retrieved data.
	 * @return data as a list of maps.
	 * @throws TablePaginationException
	 */
	protected List<Map<String, String>> formatOutputData(List<PaginationCriteria.Column> columns, List<T> data)
			throws TablePaginationException {
		List<Field> fields = new ArrayList<>();
		for (PaginationCriteria.Column col : columns) {
			try {
				fields.add(getDeclaredField(col.getData()));
			} catch (Exception e) {
				throw new TablePaginationException("Error parsing table columns", e);
			}
		}
		List<Map<String, String>> outputData = new ArrayList<Map<String, String>>();
		for (T o : data) {
			Map<String, String> recordVals = new TreeMap<>();
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					FieldFormatter f = fieldFormatters.containsKey(field.getName())
							? fieldFormatters.get(field.getName()) : BASE_FORMATTER;
					recordVals.put(field.getName(), f.format(field.get(o)));
				} catch (Exception e) {
					throw new TablePaginationException("Error generating output data", e);
				}
			}
			outputData.add(recordVals);
		}
		return outputData;
	}

	/**
	 * Uses reflection to extract required values from objects.
	 * @param field name of the object field.
	 * @return the declared field as {@code Field}.
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	protected Field getDeclaredField(String field) throws NoSuchFieldException, SecurityException {
		Field fld = getEntityType().getDeclaredField(field);
		if (fld == null) {
			if (getEntityType().getSuperclass() != null) {
				fld = getDeclaredField(field);
			}
		}
		return fld;
	}

	/**
	 * Returns the type of the entities retrieved by the repository.
	 * 
	 * @return the class of the entity.
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getEntityType() {
		return (Class<T>) entityType.getRawType();
	}

	/**
	 * Returns the repository used to retrieve, sort and filter the data.
	 * 
	 * @return the repository,
	 */
	protected TableDataService<T> getDataService() {
		return dataService;
	}
}
