package com.faunaval.api.persistencia.repository.jpa.antiguo;

import com.faunaval.api.persistencia.modelo.antiguo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPeliculaJPARepository extends JpaRepository<Pelicula,Long> {
    @Query("SELECT p FROM Pelicula p JOIN FETCH p.saga s")
    List<Pelicula> findAllWithSagas();

    @Query("SELECT p FROM Pelicula p JOIN FETCH p.saga s where p.id = :id")
    Optional<Pelicula> findByIdWithSagas(Long id);


}
