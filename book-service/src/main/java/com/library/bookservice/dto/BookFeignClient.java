package com.library.bookservice.dto;

import com.library.bookservice.entities.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "library")
public interface BookFeignClient {

    @PostMapping("book")
    ResponseEntity<Book> addBook(@RequestBody Book book);

    @GetMapping("book/{genre}")
    ResponseEntity<List<Book>> sortByGenre(@PathVariable("genre") String genre);

    @DeleteMapping("book/{id}")
    ResponseEntity deleteBook(@PathVariable("id") String id);
}


