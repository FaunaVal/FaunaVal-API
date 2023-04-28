package com.faunaval.api.rest.mapper;



import com.faunaval.api.persistencia.modelo.Categoria;
import com.faunaval.api.rest.dto.CategoriaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaMapper {

    public static CategoriaDTO toDTO(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());

        return categoriaDTO;
    }

    public static CategoriaDTO toDTO(Optional<Categoria> categoriaOptional){
        if(categoriaOptional.isEmpty()){
            return null;
        }
        return CategoriaMapper.toDTO(categoriaOptional.get());
    }

    public static List<CategoriaDTO> toDTO(List<Categoria> categorias){
        List<CategoriaDTO> categoriaDTOS= new ArrayList<>();

        if(categorias==null){
            return categoriaDTOS;
        }
        for (Categoria categoria:categorias) {
            categoriaDTOS.add(CategoriaMapper.toDTO(categoria));
        }
        return categoriaDTOS;
    }

    public static Categoria toBD(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setNombre(categoriaDTO.getNombre());

        return categoria;
    }

    public static List<Categoria> toBD(List<CategoriaDTO> categoriaDTOS){
        List<Categoria> categorias = new ArrayList<>();
        if(categoriaDTOS==null){
            return categorias;
        }
        for(CategoriaDTO categoriaDTO: categoriaDTOS){
            categorias.add(CategoriaMapper.toBD(categoriaDTO));
        }
        return categorias;
    }
}
