package com.sparta.spring_7_reactive_examples.repository;

import com.sparta.spring_7_reactive_examples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * Author: M
 * Date: 27-Feb-26
 * Project Name: spring-7-reactive-examples
 * Description: beExcellent
 */
public interface PersonRepository {


    Mono<Person> findByPersonId(Integer personId);

    Flux<Person> findAll();
}
