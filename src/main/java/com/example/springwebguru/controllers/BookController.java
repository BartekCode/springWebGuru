package com.example.springwebguru.controllers;

import com.example.springwebguru.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/all")
    public String getBooks(Model model){
        //dodajemy atrybut jako books bedą to wszystkei książki
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}


