package com.example.springwebguru.model.repositories;

import com.example.springwebguru.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends  CrudRepository <Author, Long>{
}
