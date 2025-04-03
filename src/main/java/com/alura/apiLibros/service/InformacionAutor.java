package com.alura.apiLibros.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InformacionAutor(
        @JsonProperty("name") String nombreAutor
) {

}



