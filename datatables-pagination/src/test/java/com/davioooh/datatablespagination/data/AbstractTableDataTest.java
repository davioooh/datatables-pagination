package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.commons.AbstractTableDataStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractTableDataTest {

    @Test
    void shouldReturnPageEntries() throws TableDataException {
        List<Map<String, String>> data = new AbstractTableDataStub(new ObjectMapper())
                .getPageEntries(null);

        assertEquals(AbstractTableDataStub.TEST_DATA.size(), data.size(), "size");
        assertEquals(AbstractTableDataStub.TEST_DATA.get(0).getName(), data.get(0).get("name"), "name");
        assertEquals(String.valueOf(AbstractTableDataStub.TEST_DATA.get(1).getId()), data.get(1).get("id"), "id");
        assertEquals(String.valueOf(AbstractTableDataStub.TEST_DATA.get(2).getAge()), data.get(2).get("age"), "age");
    }

}