package com.sparta.spring_7_reactive_examples.repository;

import com.sparta.spring_7_reactive_examples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {

    PersonRepository personRepository = new PersonRepositoryImpl();

    @Test
    void findByPersonId() {
    }
    @Test
    void givePersonId_whenFindByPersonId_thenReturnMonoOfPerson() {

        // GIVEN
        Integer personId = 1;

        // WHEN
        Mono<Person> peronMono = PersonRepository.findByPersonId(personId);
    }

    @Test
    void findAll() {
    }
}