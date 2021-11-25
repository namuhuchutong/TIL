package MyDITest;

import MyDI.Inject;

public class BookService {

    @Inject
    BookRepository bookRepository;
}
