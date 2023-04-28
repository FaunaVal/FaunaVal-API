package com.faunaval.api.rest.mapper.antiguo;

import com.faunaval.api.persistencia.modelo.antiguo.Pelicula;
import com.faunaval.api.rest.dto.antiguo.PeliculaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeliculaMapper {

    public static PeliculaDTO toDTO(Pelicula pelicula, Boolean withSagas){
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(pelicula.getId());
        peliculaDTO.setNombre(pelicula.getNombre());

        if(withSagas){
            peliculaDTO.setSaga(SagaMapper.toDTO(pelicula.getSaga(),false));
        }
        return peliculaDTO;
    }

    public static PeliculaDTO toDTO(Optional<Pelicula> peliculaOptional,Boolean withSagas){
        if(peliculaOptional.isEmpty()){
            return null;
        }
        return PeliculaMapper.toDTO(peliculaOptional.get(),withSagas);
    }

    public static List<PeliculaDTO> toDTO(List<Pelicula> peliculas,Boolean withSagas){
        List<PeliculaDTO> peliculaDTOS= new ArrayList<>();

        if(peliculas==null){
            return peliculaDTOS;
        }
        for (Pelicula pelicula:peliculas) {
            peliculaDTOS.add(PeliculaMapper.toDTO(pelicula,withSagas));
        }
        return peliculaDTOS;
    }

    public static Pelicula toBD(PeliculaDTO peliculaDTO,Boolean withSagas){
        Pelicula pelicula = new Pelicula();
        pelicula.setId(peliculaDTO.getId());
        pelicula.setNombre(peliculaDTO.getNombre());
        if(withSagas){
            pelicula.setSaga(SagaMapper.toBD(peliculaDTO.getSaga(),false));
        }

        return pelicula;
    }

    public static List<Pelicula> toBD(List<PeliculaDTO> peliculaDTOS, Boolean withSagas){
        List<Pelicula> peliculas = new ArrayList<>();
        if(peliculaDTOS==null){
            return peliculas;
        }
        for(PeliculaDTO peliculaDTO: peliculaDTOS){
            peliculas.add(PeliculaMapper.toBD(peliculaDTO,withSagas));
        }
        return peliculas;
    }

}
