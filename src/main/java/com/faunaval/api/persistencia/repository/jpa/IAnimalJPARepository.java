package com.faunaval.api.persistencia.repository.jpa;

import com.faunaval.api.persistencia.modelo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAnimalJPARepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a " +
            "JOIN FETCH a.fotos f " +
            "INNER JOIN a.categoria c " +
            "where c.id = :id")
    List<Animal> findAllListInfo(Long id);

    @Query("SELECT a FROM Animal a " +
            "JOIN FETCH a.fotos f " +
            "INNER JOIN a.categoria c " +
            "where (c.id = :id and a.filtro like :filter)")
    List<Animal> findAllListInfoFiltered(Long id, String filter);

    @Query("SELECT a FROM Animal a " +
            "JOIN FETCH a.fotos f " +
            "INNER JOIN a.categoria c " +
            "where a.id = :id")
    Optional<Animal> findByIdWithInfo(Long id);
}
