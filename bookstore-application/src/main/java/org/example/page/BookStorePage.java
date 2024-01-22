package org.example.page;

import org.example.model.BookTableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BookStorePage extends AbstractPage {

    @FindBy(id = "searchBox")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@class='rt-tr-group' and *[not(contains(@class, 'padRow'))]]")
    private List<WebElement> tableRow;


    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        openPage(Path.BOOK_STORE_URI);
    }

    public void fillSearchInput(String searchText) {
        searchInput.sendKeys(searchText);
    }

    public void clickGoToNextPage() {
//
    }

    public List<BookTableRow> getBooks() {
        List<BookTableRow> bookTableRows = new ArrayList<>();

        for (WebElement row : tableRow) {
            BookTableRow bookTableRow = new BookTableRow();

            bookTableRow.setTitle(row.findElement(By.xpath(".//*[@class='action-buttons']/span/a")).getText());
            bookTableRow.setAuthor(row.findElements(By.className("rt-td")).get(2).getText());
            bookTableRow.setPublisher(row.findElements(By.className("rt-td")).get(3).getText());

            bookTableRows.add(bookTableRow);
        }
        return bookTableRows;
    }

    public String getSearchFieldText() {
        return searchInput.getText();
    }
}
