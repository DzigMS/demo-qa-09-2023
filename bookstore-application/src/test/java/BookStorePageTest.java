import org.example.BookstorePageStep;
import org.example.config.ConfigProvider;
import org.example.model.BookTableRow;
import org.example.page.BookStorePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class BookStorePageTest {
    private WebDriver browser;
    private BookStorePage page;

    private BookstorePageStep bookstorePageStep;

    @BeforeEach
    public void setUp() {
        browser= ConfigProvider.getDriver();
        page = new BookStorePage(browser);
        page.openPage();

        bookstorePageStep = new BookstorePageStep(page);
    }

    @AfterEach
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void getAllBookTest() {
        BookTableRow expectedBook = new BookTableRow();
        expectedBook.setTitle("Git Pocket Guide");
        expectedBook.setAuthor("Richard E. Silverman");
        expectedBook.setPublisher("O'Reilly Media");

        List<BookTableRow> books = page.getBooks();
        System.out.println(books);

        Assertions.assertTrue(books.contains(expectedBook));
        Assertions.assertEquals(8, books.size());
    }
}
