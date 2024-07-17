package com.alura.challange.literalura.client.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Respuesta(
        @JsonAlias("count")  int count,
        @JsonAlias("next")  String next,
        @JsonAlias("previous")  String previous,
        @JsonAlias("results") List<DatosLibro> results

) {

}
