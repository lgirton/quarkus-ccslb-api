package com.sdgesi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;

@Singleton
public class DefaultObjectMapperCustomizer implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper objectMapper) {
        // To suppress serializing properties with null values
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
