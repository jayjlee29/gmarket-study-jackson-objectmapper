package com.gmarket.study.jackson;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Person {
    private String name;
    private int age;
}
