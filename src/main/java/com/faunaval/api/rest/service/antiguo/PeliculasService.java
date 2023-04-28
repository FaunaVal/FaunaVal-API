package com.faunaval.api.rest.service.antiguo;

import com.faunaval.api.persistencia.modelo.antiguo.Pelicula;
import com.faunaval.api.persistencia.repository.jpa.antiguo.IPeliculaJPARepository;
import com.faunaval.api.rest.dto.antiguo.PeliculaDTO;
import com.faunaval.api.rest.mapper.antiguo.PeliculaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculasService {

    @Autowired
    IPeliculaJPARepository peliculaJPARepository;

    public Long count(){
        return this.peliculaJPARepository.count();
    }

    public List<PeliculaDTO> findAll(Boolean withSagas){
        List<Pelicula> peliculas = this.findAllAccordingParameters(withSagas);
        return PeliculaMapper.toDTO(peliculas,withSagas);
    }

    private List<Pelicula> findAllAccordingParameters(Boolean withSagas){
        if(withSagas){
            return this.peliculaJPARepository.findAllWithSagas();
        }
        return this.peliculaJPARepository.findAll();
    }

    public PeliculaDTO findById(Long id,Boolean withSagas){
        if(withSagas){
            Optional<Pelicula> pelicula = this.peliculaJPARepository.findByIdWithSagas(id);
            return PeliculaMapper.toDTO(pelicula,withSagas);
        }
        Optional<Pelicula> pelicula = this.peliculaJPARepository.findById(id);
        return PeliculaMapper.toDTO(pelicula,withSagas);
    }

    public PeliculaDTO create(PeliculaDTO peliculaDTO,Boolean withSagas){
        Pelicula pelicula = PeliculaMapper.toBD(peliculaDTO,withSagas);
        pelicula = this.peliculaJPARepository.save(pelicula);
        return PeliculaMapper.toDTO(pelicula,withSagas);
    }

    public void update(PeliculaDTO peliculaDTO,Boolean withSagas){
        Pelicula pelicula = PeliculaMapper.toBD(peliculaDTO,withSagas);
        this.peliculaJPARepository.save(pelicula);

    }

    public void delete(PeliculaDTO peliculaDTO,Boolean withSagas){
        Pelicula pelicula = PeliculaMapper.toBD(peliculaDTO,withSagas);
        this.peliculaJPARepository.delete(pelicula);

    }

}
