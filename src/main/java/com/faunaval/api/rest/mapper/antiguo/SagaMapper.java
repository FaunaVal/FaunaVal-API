package com.faunaval.api.rest.mapper.antiguo;

import com.faunaval.api.persistencia.modelo.antiguo.Saga;
import com.faunaval.api.rest.dto.antiguo.SagaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SagaMapper {

    public static SagaDTO toDTO(Saga saga, Boolean withPeliculas){
        SagaDTO sagaDTO = new SagaDTO();
        sagaDTO.setId(saga.getId());
        sagaDTO.setNombre(saga.getNombre());
        sagaDTO.setAnyoInicio(saga.getAnyoInicio());
        sagaDTO.setAnyoFinal(saga.getAnyoFinal());
        if(withPeliculas){
            sagaDTO.setPeliculaList(PeliculaMapper.toDTO(saga.getPeliculas(),false));
        }

        return sagaDTO;
    }

    public static SagaDTO toDTO(Optional<Saga> sagaOptional,Boolean withPeliculas){
        if(sagaOptional.isEmpty()){
            return null;
        }
        return SagaMapper.toDTO(sagaOptional.get(),withPeliculas);
    }

    public static List<SagaDTO> toDTO(List<Saga> sagas,Boolean withPeliculas){
        List<SagaDTO> sagaDTOS= new ArrayList<>();

        if(sagas==null){
            return sagaDTOS;
        }
        for (Saga saga:sagas) {
            sagaDTOS.add(SagaMapper.toDTO(saga,withPeliculas));
        }
        return sagaDTOS;
    }

    public static Saga toBD(SagaDTO sagaDTO,Boolean withPeliculas){
        Saga saga = new Saga();
        saga.setId(sagaDTO.getId());
        saga.setNombre(sagaDTO.getNombre());
        saga.setAnyoInicio(sagaDTO.getAnyoInicio());
        saga.setAnyoFinal(sagaDTO.getAnyoFinal());
        if(withPeliculas){
            saga.setPeliculas(PeliculaMapper.toBD(sagaDTO.getPeliculaList(),false));
        }

        return saga;
    }

}
