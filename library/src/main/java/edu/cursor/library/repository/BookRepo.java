package edu.cursor.library.repository;

import edu.cursor.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,String> {
}
