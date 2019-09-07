package edu.cursor.library.repository;

import edu.cursor.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,String> {

}
