package com.faunaval.api.persistencia.repository.jpa.antiguo;

import com.faunaval.api.persistencia.modelo.antiguo.Saga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ISagaJPARepository extends JpaRepository<Saga,Long> {
    @Query("SELECT s FROM Saga s JOIN FETCH s.peliculas p")
    List<Saga> findAllWithPeliculas();

    @Query("SELECT s FROM Saga s JOIN FETCH s.peliculas p where s.id = :id")
    Optional<Saga> findByIdWithPeliculas(Long id);

}
