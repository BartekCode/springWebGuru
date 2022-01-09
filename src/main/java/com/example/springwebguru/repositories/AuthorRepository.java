package com.example.springwebguru.repositories;

import com.example.springwebguru.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends  CrudRepository <Author, Long>{


    //TODO zrobic jakąś samodzielną metode repository jak w todo app
}
