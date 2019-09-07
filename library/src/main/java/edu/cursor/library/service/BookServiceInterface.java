package edu.cursor.library.service;

import edu.cursor.library.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    Book addBook(Book book);

    List<Book> sortByGenre(String genre);

    void deleteBook(String id);
}
