package com.gmarket.study.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jaeglee
 * @version : 1.0.0
 * @package : com.gmarket.illit.adcenter.config
 * @name : JacksonWithParameterNamesModuleTest.java
 * @desc :
 * @date : 2025. 2. 3. AM 11:06
 * @modifyed :
 **/
@DisplayName("ParameterNamesModule 등록")
@Slf4j
public class JacksonWithParameterNamesModuleTest {


    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new ParameterNamesModule());
        return objectMapper;
    }

    @DisplayName("ParameterNamesModule 적용 > Test001(protected constructors) > 정상 생성")
    @Test
    void test001_class_Test001() {
        ObjectMapper objectMapper = getObjectMapper();
        Assertions.assertDoesNotThrow(()->{
            Person obj = objectMapper.readValue("{ \"name\":\"jaeglee\", \"age\": 99 }", Person.class);
            log.info("obj : {}", obj);
        });
    }

    @DisplayName("ParameterNamesModule 적용 > Test002(default constructor) > 정상 생성")
    @Test
    void test001_class_Test002() {
        ObjectMapper objectMapper = getObjectMapper();

        Assertions.assertDoesNotThrow(()->{
            ProposalPerson obj = objectMapper.readValue("{ \"name\":\"jaeglee\", \"age\": 99 }", ProposalPerson.class);
            log.info("obj : {}", obj);
        });

    }

}
