package org.example.page;

import org.example.config.ConfigProvider;

public interface Path {
    String BOOK_STORE_URI = ConfigProvider.getBaseDomain() + "/books";
}
