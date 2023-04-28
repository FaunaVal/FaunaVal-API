package com.faunaval.api.persistencia.modelo.antiguo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SAGAS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Saga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name="anyoinicio")
    private Long anyoInicio;
    @Column(name="anyofinal")
    private Long anyoFinal;

    @OneToMany(mappedBy = "saga")
    private List<Pelicula> peliculas;

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

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculaList) {
        this.peliculas = peliculaList;
    }

    public void addPeliculas(Pelicula pelicula){
        this.peliculas.add(pelicula);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Saga saga = (Saga) o;
        return id.equals(saga.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
