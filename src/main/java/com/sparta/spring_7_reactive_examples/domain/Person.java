package com.sparta.spring_7_reactive_examples.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Author: M
 * Date: 27-Feb-26
 * Project Name: spring-7-reactive-examples
 * Description: beExcellent
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer personId;

    private String firstName;
    private String lastName;
}
