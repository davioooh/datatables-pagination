package com.davioooh.datatablespagination.data;

public class TableDataException extends Exception {
    public TableDataException(String string, Throwable ex) {
        super(string, ex);
    }

    public TableDataException(String message) {
        super(message);
    }

}
