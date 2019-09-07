package edu.cursor.library.service;

import edu.cursor.library.entity.Book;
import edu.cursor.library.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService implements BookServiceInterface{
    private final BookRepo bookRepo;


    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> sortByGenre(String genre) {
        return bookRepo.findAll().stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }
}
