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
    void givenPersonId_whenFindByPersonId_thenReturnMonoOfPerson() {

        // GIVEN
        Integer personId = 1;

        // WHEN
        Mono<Person> personMono = personRepository.findByPersonId(personId);

        Person person = personMono.block();

        // THEN
        assertNotNull(personMono);
        System.out.println(personMono.toString());
        System.out.println(person.toString());
    }

    @Test
    void givenPersonId_whenFindByPersonId_thenReturnMonoOfPerson_subscribe() {
        // GIVEN
        Integer personId = 1;

        // WHEN
        Mono<Person> personMono = personRepository.findByPersonId(personId);

        // THEN
        assertNotNull(personMono);
        System.out.println(personMono.toString());
        personMono.subscribe(p -> System.out.println(p.toString()));
    }
    @Test
    void givenPersonId_whenFindByPersonId_thenReturnMonoOfPerson_subscribeWithLambda() {
        // GIVEN
        Integer personId = 1;

        // WHEN
        Mono<Person> personMono = personRepository.findByPersonId(personId);

        // THEN
        assertNotNull(personMono);
        System.out.println(personMono.toString());
        personMono.subscribe(System.out::println);

    }
    @Test
    void givenPersonId_whenFindByPersonId_thenReturnMonoOfPerson_mapAndSubscribe() {
        // GIVEN
        Integer personId = 1;

        // WHEN
        Mono<Person> personMono = personRepository.findByPersonId(personId);

        // THEN
        assertNotNull(personMono);
        System.out.println(personMono.toString());
        personMono.map(person -> {
            return person.getFirstName();
        }).subscribe( firstName -> System.out.println(firstName));

    }


        @Test
    void findAll() {
    }
}