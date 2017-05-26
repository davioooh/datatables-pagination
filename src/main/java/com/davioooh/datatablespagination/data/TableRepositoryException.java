package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.TablePaginationException;

public class TableRepositoryException extends TablePaginationException {
    public TableRepositoryException(String string, Throwable ex) {
        super(string, ex);
    }
}
