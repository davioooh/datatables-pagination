package com.davioooh.paginationdemo;

import com.davioooh.datatablespagination.SimplePaginator;
import com.davioooh.datatablespagination.TablePaginator;
import com.davioooh.datatablespagination.model.PaginationCriteria;
import com.davioooh.datatablespagination.model.TablePage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private TablePaginator paginator = new SimplePaginator(
            new UserTableRepository());

    @GetMapping
    public String getUsers() {
        return "list";
    }

    @PostMapping("/data")
    public @ResponseBody
    TablePage getUsersData(@RequestBody PaginationCriteria treq) {
        return paginator.getPage(treq);
    }
}