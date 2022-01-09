package com.example.springwebguru.model.repositories;

import com.example.springwebguru.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
