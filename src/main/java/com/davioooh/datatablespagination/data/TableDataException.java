package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.TablePaginationException;

public class TableDataException extends TablePaginationException {
    public TableDataException(String string, Throwable ex) {
        super(string, ex);
    }
}
