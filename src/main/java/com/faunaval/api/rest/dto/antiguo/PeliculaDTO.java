package com.faunaval.api.rest.dto.antiguo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PeliculaDTO {

    private Long id;
    private String nombre;
    private SagaDTO saga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SagaDTO getSaga() {
        return saga;
    }

    public void setSaga(SagaDTO saga) {
        this.saga = saga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaDTO pelicula = (PeliculaDTO) o;
        return id.equals(pelicula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
