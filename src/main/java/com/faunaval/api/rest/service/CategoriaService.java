package com.faunaval.api.rest.service;

import com.faunaval.api.persistencia.modelo.Categoria;
import com.faunaval.api.persistencia.repository.jpa.ICategoriaJPARepository;
import com.faunaval.api.rest.dto.CategoriaDTO;
import com.faunaval.api.rest.mapper.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoriaService {

    @Autowired
    ICategoriaJPARepository categoriaJPARepository;

    public Long count(){
        return this.categoriaJPARepository.count();
    }

    public List<CategoriaDTO> findAll(){
        List<Categoria> categorias = this.findAllAccordingParameters();
        return CategoriaMapper.toDTO(categorias);
    }

    private List<Categoria> findAllAccordingParameters (){
//        if(withGroups){
//            return this.CategoriaJPARepository.findAllWithGroups();
//        }
        return this.categoriaJPARepository.findAll();
    }

    public CategoriaDTO findById(Long id){

//        if(withGroups){
//            Optional<Categoria> Categoria = this.CategoriaJPARepository.findByIdWithGroups(id);
//            return CategoriaMapper.toDTO(Categoria,withGroups);
//        }
        Optional<Categoria> categoria = this.categoriaJPARepository.findById(id);
        return CategoriaMapper.toDTO(categoria);
    }

    public CategoriaDTO create(CategoriaDTO categoriaDTO){
        Categoria categoria = CategoriaMapper.toBD(categoriaDTO);
        categoria = this.categoriaJPARepository.save(categoria);
        return CategoriaMapper.toDTO(categoria);
    }

    public void update(CategoriaDTO categoriaDTO){
        Categoria categoria = CategoriaMapper.toBD(categoriaDTO);
        this.categoriaJPARepository.save(categoria);

    }

    public void delete(CategoriaDTO categoriaDTO){
        Categoria categoria = CategoriaMapper.toBD(categoriaDTO);
        this.categoriaJPARepository.delete(categoria);

    }
}
