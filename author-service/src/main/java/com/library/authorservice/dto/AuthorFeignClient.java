package com.library.authorservice.dto;

import com.library.authorservice.entity.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "library")
public interface AuthorFeignClient {

    @PostMapping("author")
    ResponseEntity<Author> addAuthor(@RequestBody Author author);

    @DeleteMapping("author/{id}")
    ResponseEntity deleteAuthor(@PathVariable("id") String id);

    @GetMapping("author/{id}")
    ResponseEntity<Author> getAuthorById(@PathVariable("id") String id);

    @GetMapping
    ResponseEntity<List<Author>> findAllAuthors();

}
