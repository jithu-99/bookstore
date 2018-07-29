/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Jithendra Chikkanna
 */
@Configuration

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.bookstore.service", "com.bookstore.repository"})
public class ApplicationConfiguration {

    /**
     * This method creates an instance of the Jackson {@link ObjectMapper} used to convert a JSON stream into a domain
     * object.
     *
     * @return An instance of the {@link ObjectMapper} used to convert a JSON stream into a domain object.
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        return objectMapper;
    }

}
