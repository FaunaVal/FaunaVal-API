package com.faunaval.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalDTO {

    private Long id;
    private String nombreComun;
    private String nombreCient;
    private String clase;
    private String orden;
    private String familia;
    private String descripcion;
    private String filtro;
    private CategoriaDTO categoria;
    private List<FotoDTO> fotos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCient() {
        return nombreCient;
    }

    public void setNombreCient(String nombreCient) {
        this.nombreCient = nombreCient;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public CategoriaDTO getCategoriaDTO() {
        return categoria;
    }

    public void setCategoriaDTO(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public List<FotoDTO> getFotosDTO() {
        return fotos;
    }

    public void setFotosDTO(List<FotoDTO> fotos) {
        this.fotos = fotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDTO animalDTO = (AnimalDTO) o;
        return Objects.equals(id, animalDTO.id) && Objects.equals(nombreComun, animalDTO.nombreComun) && Objects.equals(nombreCient, animalDTO.nombreCient) && Objects.equals(clase, animalDTO.clase) && Objects.equals(orden, animalDTO.orden) && Objects.equals(familia, animalDTO.familia) && Objects.equals(descripcion, animalDTO.descripcion) && Objects.equals(filtro, animalDTO.filtro) && Objects.equals(categoria, animalDTO.categoria) && Objects.equals(fotos, animalDTO.fotos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreComun, nombreCient, clase, orden, familia, descripcion, filtro, categoria, fotos);
    }
}
