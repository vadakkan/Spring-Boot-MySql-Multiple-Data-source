package com.nitheesh.mvc.primary.controller;

import com.nitheesh.mvc.primary.domain.Person;
import com.nitheesh.mvc.primary.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("primary")
public class PrimaryController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/all")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
