package com.library.bookservice.controller;

import com.library.bookservice.dto.BookFeignClient;
import com.library.bookservice.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookFeignClient bookFeignClient;

    @PostMapping("book")
    @ResponseBody
    public ResponseEntity addBook(@RequestBody Book book) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookFeignClient.addBook(book));
    }

    @GetMapping("book/{genre}")
    public ResponseEntity sortByGenre(@PathVariable("genre") String genre) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookFeignClient.sortByGenre(genre));
    }

    @DeleteMapping("book/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") String id) {

        bookFeignClient.deleteBook(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Book by id " + id + " was deleted successfully");
    }
}
