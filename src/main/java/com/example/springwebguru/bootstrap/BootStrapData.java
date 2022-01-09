package com.example.springwebguru.bootstrap;

import com.example.springwebguru.model.Author;
import com.example.springwebguru.model.Book;
import com.example.springwebguru.model.Publisher;
import com.example.springwebguru.repositories.AuthorRepository;
import com.example.springwebguru.repositories.BookRepository;
import com.example.springwebguru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author(1L, "Eric", "Schwars");
        Book ddd = new Book(1L, "Domain driven designe", "12sada");

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author(2L, "Rod", "Johnson");
        Book noEJB = new Book(3L, "J2EE", "3213123");

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Optional<Author> byId = authorRepository.findById(1L);
        System.out.println("Pobieramy z bazu authora o id 1L " + byId.get().getFirstName());
        System.out.println("Number of books: " + bookRepository.count());

        Publisher publisher = new Publisher(5L, "Bink", "Warsaw", "Mazovia", "Wyzwo", "01-002");

        publisherRepository.save(publisher);

        System.out.println("Publisher mieszka w : " + publisherRepository.findById(5L).get().getCity());
    }
}
