package com.davioooh.datatablespagination.data;

public class TableDataException extends RuntimeException {
    public TableDataException(String string, Throwable ex) {
        super(string, ex);
    }
}
