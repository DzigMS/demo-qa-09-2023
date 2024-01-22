package org.example;

import org.example.page.BookStorePage;

public class BookstorePageStep {
    private BookStorePage bookStorePage;

    public BookstorePageStep(BookStorePage bookStorePage) {
        this.bookStorePage = bookStorePage;
    }

    public void fillSearchField(String search) {
        bookStorePage.fillSearchInput(search);
//        bookStorePage.getSearchFieldText();
//        assert
    }
}
