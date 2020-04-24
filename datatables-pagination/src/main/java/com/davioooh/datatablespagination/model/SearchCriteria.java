package com.davioooh.datatablespagination.model;

public class SearchCriteria {

    /**
     * Search value. To be applied to all columns which have searchable as
     * true.
     */
    private String value;

    /**
     * true if the filter should be treated as a regular expression for
     * advanced searching, false otherwise.
     */
    private boolean regex; // not used

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRegex() {
        return regex;
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }

}