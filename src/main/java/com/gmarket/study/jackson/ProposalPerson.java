package com.gmarket.study.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ProposalPerson {
    private String name;
    private int age;

    @JsonCreator
    protected ProposalPerson() {

    }

    protected ProposalPerson(String name, int age) {

        this.name = name;
        this.age = age;
    }

}
