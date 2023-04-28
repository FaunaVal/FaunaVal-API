package com.faunaval.api.persistencia.repository.jpa;

import com.faunaval.api.persistencia.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaJPARepository extends JpaRepository<Categoria,Long> {
}
