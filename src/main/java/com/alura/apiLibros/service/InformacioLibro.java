package com.alura.apiLibros.service;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InformacioLibro(
        @JsonProperty("title") String tituloLibro,
        @JsonProperty("authors") List<InformacionAutor> autoresLibro,
        @JsonProperty("download_count") Integer numeroDescargasLibro
        )
{

}


