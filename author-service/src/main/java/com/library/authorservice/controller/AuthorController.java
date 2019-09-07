package com.library.authorservice.controller;

import com.library.authorservice.dto.AuthorFeignClient;
import com.library.authorservice.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorFeignClient authorFeignClient;

    @PostMapping("author")
    @ResponseBody
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        authorFeignClient.addAuthor(author);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("author/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") String id) {
        authorFeignClient.deleteAuthor(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Author by id " + id + " was deleted successfully");
    }

    @GetMapping("author/{id}")
    public ResponseEntity getAuthorById(@PathVariable("id") String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorFeignClient.getAuthorById(id));
    }

    @GetMapping
    public ResponseEntity findAllAuthors() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorFeignClient.findAllAuthors());
    }
}
