package is.restclient.commandline;

import is.restclient.api.BookControllerApi;
import is.restclient.model.Book;
import is.restclient.model.BookToAdd;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MakeRequestCmdLIneRunner implements CommandLineRunner {

    private final BookControllerApi bookControllerApi;

    public MakeRequestCmdLIneRunner(BookControllerApi bookControllerApi) {
        this.bookControllerApi = bookControllerApi;
    }

    @Override
    public void run(String... args) throws Exception {
        BookToAdd bookToAdd = new BookToAdd();
        bookToAdd.setTitle("A new title");

        final Book addedBook = bookControllerApi.addBook(bookToAdd);
        System.out.printf("A new book has ID '%d'\n", addedBook.getId());
    }
}
