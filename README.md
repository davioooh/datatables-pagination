# DataTables Pagination

Java server-side pagination utility for [DataTables](https://datatables.net/) jQuery plug-in.

## Usage Example

Here I provide a simple usage example in a Spring MVC project.

### 1. Repository

First of all you need to define the logic to retrieve + sort + filter data from your data source. 
You do this implementing `TableRepository`:

    public class UserTableRepository implements TableRepository<User> {
    
        private static final List<User> TEST_DATA = Arrays.asList(new User(1, "Lisa", 20), new User(2, "Tom", 31),
                new User(3, "David", 38), new User(4, "Marco", 23), new User(5, "Jenny", 15));
    
        @Override
        public long countTotalEntries() throws TableRepositoryException {
            return TEST_DATA.size();
        }
    
        @Override
        public List<User> findPageEntries(PaginationCriteria pCriteria)
                throws TableRepositoryException {
            // ... order and filter your data here
            return TEST_DATA;
        }
    
    }

I'm using this simple entity class:

    public class User {
    
        private int id;
        private String name;
        private int age;
        
        // ... constructor + accessors
        
    }

Probably you store your data in a DB, so you could use JPA or plain JDBC to query your data source and to implement ordering.

### 2. Table pager

You also need to provide an implementation of `AbstractTablePaginator`, but this is quite simple. For example:

    public class UserTablePaginator extends AbstractTablePaginator<User> {
    
        public UserTablePager(TablePagerRepository<User> repo) {
            super(repo);
        }
    
    }

This way you specify which entity type to retrieve and to process.

### 3. Controller

Finally you can use the paginator in a controller.
This is very simple, because you just need to instantiate a `TablePaginator` and use directly in the action method. 
You'll get `PaginationCriteria` as request payload and the method will return a `TablePage` as response body:

    @Controller
    @RequestMapping("/users")
    public class UserController {
    
        private TablePaginator paginator = 
            new UserTablePaginator(new UserTableRepository()); // <-- here you can use autowiring
    
        @RequestMapping
        public String getUsers() {
            return "list";
        }
    
        @RequestMapping(value = "/data", method = RequestMethod.POST)
        public @ResponseBody TablePage getUsersData(@RequestBody PaginationCriteria treq) {
            try {
                return paginator.getPage(treq);
            } catch (TablePaginationException e) {
                return null;
            }
        }
    }

### 4. On Client side

In your page you just need to include fiew lines of JavaScript:

    <!DOCTYPE html>
    <html>
    <head>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/jq-2.2.3/dt-1.10.12/datatables.css" />
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-2.2.3/dt-1.10.12/datatables.js" />
    <script type="text/javascript">
        $(document).ready(function() {
            $('#example').DataTable({
                "processing" : true,
                "serverSide" : true,
                "columns": [ // NOTE: you need to specify names of fields as ids for the columns
                    { "data": "id" },
                    { "data": "name" },
                    { "data": "age" }
                ],
                "ajax": {
                    "url": "users/data",
                    "type": "POST",
                    "contentType" : "application/json; charset=utf-8",			    
                    "data": function ( d ) {
                        return JSON.stringify(d); // NOTE: you also need to stringify POST payload
                    }
                }
            });
        });
    </script>
    </head>
    <body>
        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
            </thead>
        </table>
    </body>
    </html>

Notice that you need to set names for table columns matching fields in you server-side entities.
