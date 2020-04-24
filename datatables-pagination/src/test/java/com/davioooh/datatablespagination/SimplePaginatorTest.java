package com.davioooh.datatablespagination;

import com.davioooh.datatablespagination.commons.ErrorTableDataStub;
import com.davioooh.datatablespagination.commons.TableDataStub;
import com.davioooh.datatablespagination.model.request.PaginationCriteria;
import com.davioooh.datatablespagination.model.response.TablePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplePaginatorTest {

    @Test
    public void shouldReturnTablePage() {
        TablePage page = new SimplePaginator(new TableDataStub())
                .getPage(fakePaginationCriteria());

        assertNull(page.getError(), "error");
        assertEquals(fakePaginationCriteria().getDraw(), page.getDraw(), "draw");
        assertEquals(TableDataStub.pageEntries.size(), page.getRecordsTotal(), "recordsTotal");
        assertEquals(TableDataStub.filteredEntries.size(), page.getRecordsFiltered(), "recordsFiltered");
        assertEquals(TableDataStub.filteredEntries, page.getData(), "data");
    }

    private PaginationCriteria fakePaginationCriteria() {
        PaginationCriteria paginationCriteria = new PaginationCriteria();
        paginationCriteria.setDraw(1);
        return paginationCriteria;
    }

    @Test
    void shouldReturnPaginationError() {
        TablePage page = new SimplePaginator(new ErrorTableDataStub())
                .getPage(fakePaginationCriteria());

        assertNotNull(page.getError(), "error");
        assertEquals(0, page.getDraw(), "draw");
        assertEquals(0, page.getRecordsTotal(), "recordsTotal");
        assertEquals(0, page.getRecordsFiltered(), "recordsFiltered");
        assertNull(page.getData(), "data");
    }

}