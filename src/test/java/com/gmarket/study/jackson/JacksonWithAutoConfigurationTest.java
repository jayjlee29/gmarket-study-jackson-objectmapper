package com.gmarket.study.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : jaeglee
 * @version : 1.0.0
 * @package : com.gmarket.illit.adcenter.config
 * @name : JacksonWithParameterNamesModuleTest.java
 * @desc :
 * @date : 2025. 2. 3. AM 11:06
 * @modifyed :
 **/
@DisplayName("JacksonAutoConfiguration에 의해 생성된 ObjectMapper")
@Slf4j
@SpringBootTest
public class JacksonWithAutoConfigurationTest {
    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Person > 정상 생성")
    @Test
    void test001_class_Test001() {
        Assertions.assertDoesNotThrow(()->{
            Person obj = objectMapper.readValue("{ \"name\":\"jaeglee\", \"age\": 99 }", Person.class);
            log.info("obj : {}", obj);
        });
    }

    @DisplayName("ProposalPerson > 정상 생성")
    @Test
    void test001_class_Test002() {
        Assertions.assertDoesNotThrow(()->{
            ProposalPerson obj = objectMapper.readValue("{ \"name\":\"jaeglee\", \"age\": 99 }", ProposalPerson.class);
            log.info("obj : {}", obj);
        });

    }

}
