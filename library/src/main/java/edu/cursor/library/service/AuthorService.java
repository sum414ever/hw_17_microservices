package edu.cursor.library.service;

import edu.cursor.library.entity.Author;
import edu.cursor.library.exceptions.DataNotFoundException;
import edu.cursor.library.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService implements AuthorServiceInterface {
    private final AuthorRepo authorRepo;

    @Override
    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepo.deleteById(id);
    }

    @Override
    public Author getAuthorById(String id) {
        return authorRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Not found"));
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }
}
