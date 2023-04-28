package com.faunaval.api.persistencia.modelo.antiguo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PELICULAS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saga",referencedColumnName = "id")
    private Saga saga;

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

    public Saga getSaga() {
        return saga;
    }

    public void setSaga(Saga saga) {
        this.saga = saga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return id.equals(pelicula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
