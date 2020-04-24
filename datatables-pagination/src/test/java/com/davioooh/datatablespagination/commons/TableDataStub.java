package com.davioooh.datatablespagination.commons;

import com.davioooh.datatablespagination.data.TableData;
import com.davioooh.datatablespagination.data.TableDataException;
import com.davioooh.datatablespagination.model.request.PaginationCriteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableDataStub implements TableData {

    public static List<Map<String, String>> pageEntries;
    public static List<Map<String, String>> filteredEntries;

    public TableDataStub() {
        pageEntries = new ArrayList<>();

        Map<String, String> user1 = new HashMap<>();
        user1.put("id", "1");
        user1.put("name", "Lisa");
        user1.put("age", "20");
        pageEntries.add(user1);

        Map<String, String> user2 = new HashMap<>();
        user2.put("id", "2");
        user2.put("name", "Tom");
        user2.put("age", "31");
        pageEntries.add(user2);

        Map<String, String> user3 = new HashMap<>();
        user3.put("id", "3");
        user3.put("name", "David");
        user3.put("age", "38");
        pageEntries.add(user3);

        Map<String, String> user4 = new HashMap<>();
        user4.put("id", "4");
        user4.put("name", "Marco");
        user4.put("age", "23");
        pageEntries.add(user4);

        Map<String, String> user5 = new HashMap<>();
        user5.put("id", "5");
        user5.put("name", "Jenny");
        user5.put("age", "15");
        pageEntries.add(user5);

        filteredEntries = pageEntries.subList(0, 2);
    }

    @Override
    public long countTotalEntries() throws TableDataException {
        return pageEntries.size();
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        return filteredEntries.size();
    }

    @Override
    public List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        return filteredEntries;
    }

}
