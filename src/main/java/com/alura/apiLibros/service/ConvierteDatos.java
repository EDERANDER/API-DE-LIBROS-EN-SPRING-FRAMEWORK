package com.alura.apiLibros.service;

import com.alura.apiLibros.interfaces.IConvierteDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T fromJson(String Json, Class<T> clase){
        try {
            return mapper.readValue(Json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
