package com.faunaval.api.rest.service;

import com.faunaval.api.persistencia.modelo.Foto;
import com.faunaval.api.persistencia.repository.jpa.IFotoJPARepository;
import com.faunaval.api.rest.dto.FotoDTO;
import com.faunaval.api.rest.mapper.FotoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FotoService {


    @Autowired
    IFotoJPARepository fotoJPARepository;

    public Long count(){
        return this.fotoJPARepository.count();
    }

    public List<FotoDTO> findAll(){
        List<Foto> fotos = this.findAllAccordingParameters();
        return FotoMapper.toDTO(fotos);
    }

    private List<Foto> findAllAccordingParameters (){
//        if){
//            return this.FotoJPARepository.findAl();
//        }
        return this.fotoJPARepository.findAll();
    }

    public FotoDTO findById(Long id){

//        if){
//            Optional<Foto> Foto = this.FotoJPARepository.findByI(id);
//            return FotoMapper.toDTO(Foto);
//        }
        Optional<Foto> foto = this.fotoJPARepository.findById(id);
        return FotoMapper.toDTO(foto);
    }

    public FotoDTO create(FotoDTO fotoDTO){
        Foto foto = FotoMapper.toBD(fotoDTO);
        foto = this.fotoJPARepository.save(foto);
        return FotoMapper.toDTO(foto);
    }

    public void update(FotoDTO fotoDTO){
        Foto foto = FotoMapper.toBD(fotoDTO);
        this.fotoJPARepository.save(foto);

    }

    public void delete(FotoDTO fotoDTO){
        Foto foto = FotoMapper.toBD(fotoDTO);
        this.fotoJPARepository.delete(foto);

    }


}
