package com.faunaval.api.persistencia.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "animales")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_comun")
    private String nombreComun;
    @Column(name = "nombre_cient")
    private String nombreCient;
    private String clase;
    private String orden;
    private String familia;
    private String descripcion;
    private String filtro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    private Categoria categoria;

    @OneToMany(mappedBy = "animal")
    private List<Foto> fotos;


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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(nombreComun, animal.nombreComun) && Objects.equals(nombreCient, animal.nombreCient) && Objects.equals(clase, animal.clase) && Objects.equals(orden, animal.orden) && Objects.equals(familia, animal.familia) && Objects.equals(descripcion, animal.descripcion) && Objects.equals(filtro, animal.filtro) && Objects.equals(categoria, animal.categoria) && Objects.equals(fotos, animal.fotos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreComun, nombreCient, clase, orden, familia, descripcion, filtro, categoria, fotos);
    }
}
