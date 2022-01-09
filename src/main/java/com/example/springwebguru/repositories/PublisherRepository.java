package com.example.springwebguru.repositories;

import com.example.springwebguru.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
