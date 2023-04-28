package com.faunaval.api.persistencia.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "fotos")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal", referencedColumnName = "id")
    private Animal animal;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
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
        Foto foto = (Foto) o;
        return Objects.equals(id, foto.id) && Objects.equals(animal, foto.animal) && Objects.equals(url, foto.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, url);
    }
}
