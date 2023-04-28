package com.faunaval.api.rest.service.antiguo;

import com.faunaval.api.persistencia.modelo.antiguo.Saga;
import com.faunaval.api.persistencia.repository.jpa.antiguo.ISagaJPARepository;
import com.faunaval.api.rest.dto.antiguo.SagaDTO;
import com.faunaval.api.rest.mapper.antiguo.SagaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SagasService {

    @Autowired
    ISagaJPARepository sagaJPARepository;

    public Long count(){
        return this.sagaJPARepository.count();
    }

    public List<SagaDTO> findAll(Boolean withPeliculas){
        List<Saga> sagas = this.findAllAccordingParameters(withPeliculas);
        return SagaMapper.toDTO(sagas,withPeliculas);
    }

    private List<Saga> findAllAccordingParameters(Boolean withPeliculas){
        if(withPeliculas){
            return this.sagaJPARepository.findAllWithPeliculas();
        }
        return this.sagaJPARepository.findAll();
    }

    public SagaDTO findById(Long id,Boolean withPeliculas){
        if(withPeliculas){
            Optional<Saga> saga = this.sagaJPARepository.findByIdWithPeliculas(id);
            return SagaMapper.toDTO(saga,withPeliculas);
        }
        Optional<Saga> saga = this.sagaJPARepository.findById(id);
        return SagaMapper.toDTO(saga,withPeliculas);
    }

    public SagaDTO create(SagaDTO sagaDTO,Boolean withPeliculas){
        Saga saga = SagaMapper.toBD(sagaDTO,withPeliculas);
        saga = this.sagaJPARepository.save(saga);
        return SagaMapper.toDTO(saga,withPeliculas);
    }

    public void update(SagaDTO sagaDTO,Boolean withPeliculas){
        Saga saga = SagaMapper.toBD(sagaDTO,withPeliculas);
        this.sagaJPARepository.save(saga);

    }

    public void delete(SagaDTO sagaDTO,Boolean withPeliculas){
        Saga saga = SagaMapper.toBD(sagaDTO,withPeliculas);
        this.sagaJPARepository.delete(saga);

    }

}
