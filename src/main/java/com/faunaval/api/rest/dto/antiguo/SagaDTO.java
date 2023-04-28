package com.faunaval.api.rest.dto.antiguo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SagaDTO {


    private Long id;
    private String nombre;
    private Long anyoInicio;
    private Long anyoFinal;
    private List<PeliculaDTO> peliculaList;

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

    public Long getAnyoInicio() {
        return anyoInicio;
    }

    public void setAnyoInicio(Long anyoInicio) {
        this.anyoInicio = anyoInicio;
    }

    public Long getAnyoFinal() {
        return anyoFinal;
    }

    public void setAnyoFinal(Long anyoFinal) {
        this.anyoFinal = anyoFinal;
    }

    public List<PeliculaDTO> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<PeliculaDTO> peliculaList) {
        this.peliculaList = peliculaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SagaDTO saga = (SagaDTO) o;
        return id.equals(saga.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
