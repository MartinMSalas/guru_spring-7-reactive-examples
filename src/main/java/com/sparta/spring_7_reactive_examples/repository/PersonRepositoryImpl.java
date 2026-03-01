package com.sparta.spring_7_reactive_examples.repository;

import com.sparta.spring_7_reactive_examples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Author: M
 * Date: 27-Feb-26
 * Project Name: spring-7-reactive-examples
 * Description: beExcellent
 */
public class PersonRepositoryImpl implements PersonRepository {
    Person cachito = Person.builder().personId(123).firstName("Cachito").lastName("El campeon de Corrientes").build();
    Person elena = Person.builder().personId(124).firstName("Elena").lastName("la de troya").build();
    Person diostri = Person.builder().personId(125).firstName("Diostri").lastName("El rey del Salame").build();
    Person sereno = Person.builder().personId(126).firstName("Sereno").lastName("La conexion").build();


    private List<Person> personList = List.of(cachito, elena, diostri, sereno);
    private Map<Integer, Person> personMap =
            personList.stream()
                    .collect(Collectors.toMap(Person::getPersonId, Function.identity()));

    @Override
    public Mono<Person> findByPersonId(Integer personId) {

        return Mono.justOrEmpty(personMap.get(personId));

    }

    /*
    @Override
    public Mono<Person> findByPersonId(Integer personId) {
        return Mono.justOrEmpty(
                personList.stream()
                        .filter(person -> person.getPersonId().equals(personId))
                        .findFirst()
        );

    }
*/
    @Override
    public Flux<Person> findAll() {
        return Flux.fromIterable(personList);
    }
}
