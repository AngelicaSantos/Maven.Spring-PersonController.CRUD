package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.Person;
import io.zipcoder.crudapp.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Object createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) {
        return repository.findOne(id);
    }

    @GetMapping
    public List<Person> getPersonList() {
        List<Person> list = new ArrayList<>();
        repository.findAll().forEach(person -> list.add((Person) person));
        return list;
    }

    @DeleteMapping("/{id")
    public void deletePerson(@PathVariable Long id) {
        repository.delete(id);
    }










}