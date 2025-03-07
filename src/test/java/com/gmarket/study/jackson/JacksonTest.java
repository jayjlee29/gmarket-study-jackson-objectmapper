package com.gmarket.study.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("ParameterNamesModule 미 등록")
@Slf4j
public class JacksonTest {



    @DisplayName("ParameterNamesModule 미 적용 > class Person > InvalidDefinitionException 발생")
    @Test
    void test001_class_Person() {
        ObjectMapper objectMapper = new ObjectMapper();

        var ex = Assertions.assertThrows(InvalidDefinitionException.class, ()->{
            Person obj = objectMapper.readValue("{ \"name\":\"jaeglee\", \"age\": 99 }", Person.class);
            log.info("obj : {}", obj);
        });

        log.error("ex : {}", ex.toString(), ex);
    }

    @DisplayName("ParameterNamesModule 미 적용 > class ProposalPerson > 정상 생성")
    @Test
    void test001_class_ProposalPerson() {
        ObjectMapper objectMapper = new ObjectMapper();

        Assertions.assertDoesNotThrow(()->{
            ProposalPerson obj = objectMapper.readValue("{ \"name\":\"jaeglee\", \"age\": 99 }", ProposalPerson.class);
            log.info("obj : {}", obj);
        });

    }

    @DisplayName("ParameterNamesModule 미 적용 > class Person > Array > InvalidDefinitionException 발생")
    @Test
    void test001_class_Test001_array() {
        ObjectMapper objectMapper = new ObjectMapper();

        Assertions.assertThrows(InvalidDefinitionException.class, ()->{
            List<Person> array = objectMapper.readValue("[{ \"name\":\"jaeglee\", \"age\": 99 },{ \"name\":\"jaeglee02\", \"age\": 1 }]", new TypeReference<List<Person>>() {});
            log.info("array : {}", array);
            for (Person person : array) {
                log.info("person : {}", person);
            }
        });

    }

    @DisplayName("ParameterNamesModule 미 적용 > class ProposalPerson > Array > 정상 생성")
    @Test
    void test001_class_Test002_array() {
        ObjectMapper objectMapper = new ObjectMapper();

        Assertions.assertDoesNotThrow(()->{
            List<ProposalPerson> array = objectMapper.readValue("[{ \"name\":\"jaeglee\", \"age\": 99 },{ \"name\":\"jaeglee02\", \"age\": 1 }]", new TypeReference<List<ProposalPerson>>() {});
            log.info("array : {}", array);
            array.forEach(p -> log.info("p : {}", p));
        });

    }

}
