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

        Publisher publisher = new Publisher();
        publisher.setCity("Lodz");
        publisher.setState("LDZ");
        publisher.setName("Publisz FG");
        publisher.setZip("1212");
        publisher.setId(1L);

        Author eric = new Author("Eric", "Schwars");
        Book ddd = new Book( "Domain driven designe", "12sada");
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "3213123");
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(publisher);

        Optional<Author> byId = authorRepository.findById(1L);
        System.out.println("Pobieramy z bazu authora o id 1L " + byId.get().getFirstName());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
