package com.sparta.spring_7_reactive_examples.repository;

import com.sparta.spring_7_reactive_examples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

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
        personMono.map(Person::getFirstName).subscribe(System.out::println);

    }

    @Test
    void testFluxBlockFirst() {
        Flux<Person> personFlux = personRepository.findAll();
        Person person = personFlux.blockFirst();
        IO.println(person);
    }

    @Test
    void testFluxSuscribe(){
        Flux<Person> personFlux = personRepository.findAll();
        personFlux.map(Person::getFirstName).subscribe(System.out::println);

    }

    @Test
    void testFluxToList(){
        Flux<Person> personFlux = personRepository.findAll();

        Mono<List<Person>> listMono = personFlux.collectList();
        listMono.subscribe(
                list-> {
                    list.forEach(System.out::println);
                }
        );
    }

    @Test
    void testFilterOnName(){
        Flux<Person> personFlux = personRepository.findAll();
        Mono<List<Person>> listMono = personFlux.collectList();
        listMono.subscribe(
                list -> {
                    list.stream().filter(person -> person.getFirstName().equals("Diostri")).forEach(System.out::println);
                }
        );
    }

    @Test
    void anotherFilterOnName(){
        personRepository.findAll().filter(person -> person.getFirstName().equals("Diostri"))
                .subscribe(System.out::println);

    }

    @Test
    void testFindPersonByIdNotFound(){
        final Integer personId = 5;

        Mono<Person> personMono = personRepository.findByPersonId(personId).single();


        personMono.subscribe(System.out::println);
    }

    @Test
    void findAll() {
    }
}