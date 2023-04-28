package com.faunaval.api.persistencia.repository.jpa;

import com.faunaval.api.persistencia.modelo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAnimalJPARepository extends JpaRepository<Animal,Long> {

    @Query("SELECT a FROM Animal a JOIN FETCH a.fotos f")
    List<Animal> findAllListInfo();

}
