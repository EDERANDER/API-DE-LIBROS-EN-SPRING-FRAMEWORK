package com.alura.apiLibros.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface IConvierteDatos {

    <T> T fromJson(String Json, Class<T> clase);
}
