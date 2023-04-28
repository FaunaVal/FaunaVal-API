package com.faunaval.api.rest.mapper;

import com.faunaval.api.persistencia.modelo.Animal;
import com.faunaval.api.rest.dto.AnimalDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalMapper {

    public static AnimalDTO toDTO(Animal animal){
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setNombreComun(animal.getNombreComun());
        animalDTO.setNombreCient(animal.getNombreCient());
        animalDTO.setClase(animal.getClase());
        animalDTO.setOrden(animal.getOrden());
        animalDTO.setFamilia(animal.getFamilia());
        animalDTO.setDescripcion(animal.getDescripcion());
        animalDTO.setFiltro(animal.getFiltro());
        animalDTO.setFotosDTO(FotoMapper.toDTO(animal.getFotos()));

        return animalDTO;
    }

    public static AnimalDTO toDTO(Optional<Animal> animalOptional){
        if(animalOptional.isEmpty()){
            return null;
        }
        return AnimalMapper.toDTO(animalOptional.get());
    }

    public static List<AnimalDTO> toDTO(List<Animal> animals){
        List<AnimalDTO> animalDTOS= new ArrayList<>();

        if(animals==null){
            return animalDTOS;
        }
        for (Animal animal:animals) {
            animalDTOS.add(AnimalMapper.toDTO(animal));
        }
        return animalDTOS;
    }

    public static Animal toBD(AnimalDTO animalDTO){
        Animal animal = new Animal();
        animal.setId(animalDTO.getId());
        animal.setNombreComun(animalDTO.getNombreComun());
        animal.setNombreCient(animalDTO.getNombreCient());
        animal.setClase(animalDTO.getClase());
        animal.setOrden(animalDTO.getOrden());
        animal.setFamilia(animalDTO.getFamilia());
        animal.setDescripcion(animalDTO.getDescripcion());
        animal.setFiltro(animalDTO.getFiltro());
        animal.setFotos(FotoMapper.toBD(animalDTO.getFotosDTO()));

        return animal;
    }

    public static List<Animal> toBD(List<AnimalDTO> animalDTOS){
        List<Animal> animals = new ArrayList<>();
        if(animalDTOS==null){
            return animals;
        }
        for(AnimalDTO animalDTO: animalDTOS){
            animals.add(AnimalMapper.toBD(animalDTO));
        }
        return animals;
    }
}
