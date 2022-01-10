package com.example.springwebguru.controllers;

import com.example.springwebguru.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
@Slf4j
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String getAuthors(Model model){
        log.warn("Exposing all authors!");
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }
}
