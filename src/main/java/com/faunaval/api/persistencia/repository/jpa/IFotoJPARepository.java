package com.faunaval.api.persistencia.repository.jpa;

import com.faunaval.api.persistencia.modelo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFotoJPARepository extends JpaRepository<Foto,Long> {
}
