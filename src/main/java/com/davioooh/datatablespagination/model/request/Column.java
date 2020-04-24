package com.davioooh.datatablespagination.model.request;

/**
 * Table's column.
 */
public class Column {

    /**
     * Column's data source.
     */
    private String data;

    /**
     * Column's name.
     */
    private String name;

    /**
     * Flag to indicate if this column is searchable (true) or not (false).
     */
    private boolean searchable;

    /**
     * Flag to indicate if this column is orderable (true) or not (false).
     */
    private boolean orderable;

    /**
     * Search criteria to apply to this specific column.
     */
    private SearchCriteria search;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public boolean isOrderable() {
        return orderable;
    }

    public void setOrderable(boolean orderable) {
        this.orderable = orderable;
    }

    public SearchCriteria getSearch() {
        return search;
    }

    public void setSearch(SearchCriteria search) {
        this.search = search;
    }

}