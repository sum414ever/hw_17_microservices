package com.library.bookservice.entities;

import lombok.Data;

@Data
public class Book {

    private String id;
    private String title;
    private String genre;
    private double rating;
    private Author author;
}
