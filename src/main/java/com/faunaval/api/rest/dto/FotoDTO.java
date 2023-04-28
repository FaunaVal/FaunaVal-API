package com.faunaval.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.faunaval.api.persistencia.modelo.Animal;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FotoDTO {

    private Long id;
    private AnimalDTO animal;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimalDTO getAnimal() {
        return animal;
    }

    public void setAnimalDTO(AnimalDTO animal) {
        this.animal = animal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoDTO fotoDTO = (FotoDTO) o;
        return Objects.equals(id, fotoDTO.id) && Objects.equals(animal, fotoDTO.animal) && Objects.equals(url, fotoDTO.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, url);
    }
}
