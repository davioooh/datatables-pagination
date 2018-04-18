package com.davioooh.datatablespagination.data;

import com.davioooh.datatablespagination.User;
import com.davioooh.datatablespagination.model.PaginationCriteria;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceBaseTest {

    private static final List<User> TEST_DATA =
            Arrays.asList(
                    new User(1, "Lisa", 20),
                    new User(2, "Tom", 31),
                    new User(3, "David", 38),
                    new User(4, "Marco", 23),
                    new User(5, "Jenny", 15));

    private DataServiceBase dataService = new DataServiceBase<User>() {
        @Override
        public long countTotalEntries() throws TableDataException {
            return 0;
        }

        @Override
        public long countFilteredEntries(PaginationCriteria paginationCriteria) throws TableDataException {
            return 0;
        }

        @Override
        protected List<User> getData(PaginationCriteria paginationCriteria) throws TableDataException {
            return TEST_DATA;
        }
    };

    @Test
    void getPageEntries() throws TableDataException {
        List<Map<String, String>> data = dataService.getPageEntries(null);
        assertEquals(5, data.size());
        assertEquals("Lisa", data.get(0).get("name"));
        assertEquals("2", data.get(1).get("id"));
        assertEquals("38", data.get(2).get("age"));
    }
}