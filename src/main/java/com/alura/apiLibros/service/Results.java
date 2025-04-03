package com.alura.apiLibros.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(
        @JsonProperty("results")List<InformacioLibro> arrayLibros
        ) {
}
