package com.example.springwebguru.controllers;

import com.example.springwebguru.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    public static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getBooks(Model model){
        //dodajemy atrybut jako books bedą to wszystkei książki
        model.addAttribute("books", bookRepository.findAll());
        logger.warn("Exposing all books!!!");
        return "books/list";
        //bedzie szukac list template inside the directory books
    }
}


