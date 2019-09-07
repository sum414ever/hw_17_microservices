package edu.cursor.library.service;

import edu.cursor.library.entity.Author;

import java.util.List;

public interface AuthorServiceInterface {
    void addAuthor(Author author);

    void deleteAuthor(String id);

    Author getAuthorById(String id);

    List<Author> findAllAuthors();
}
