package com.faunaval.api.rest.service;

import com.faunaval.api.persistencia.modelo.Animal;
import com.faunaval.api.persistencia.repository.jpa.IAnimalJPARepository;
import com.faunaval.api.rest.dto.AnimalDTO;
import com.faunaval.api.rest.mapper.AnimalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    IAnimalJPARepository animalJPARepository;

    public Long count(){
        return this.animalJPARepository.count();
    }

    public List<AnimalDTO> findAllListInfo (){
        List<Animal> animals = animalJPARepository.findAllListInfo();
        return AnimalMapper.toDTO(animals);
    }

    public List<AnimalDTO> findAll(){
        List<Animal> animals = this.findAllAccordingParameters();
        return AnimalMapper.toDTO(animals);
    }

    private List<Animal> findAllAccordingParameters (){
//        if(withGroups){
//            return this.animalJPARepository.findAllWithGroups();
//        }
        return this.animalJPARepository.findAll();
    }

    public AnimalDTO findById(Long id){

//        if(withGroups){
//            Optional<Animal> animal = this.animalJPARepository.findByIdWithGroups(id);
//            return AnimalMapper.toDTO(animal,withGroups);
//        }
        Optional<Animal> animal = this.animalJPARepository.findById(id);
        return AnimalMapper.toDTO(animal);
    }

    public AnimalDTO create(AnimalDTO animalDTO){
        Animal animal = AnimalMapper.toBD(animalDTO);
        animal = this.animalJPARepository.save(animal);
        return AnimalMapper.toDTO(animal);
    }

    public void update(AnimalDTO animalDTO){
        Animal animal = AnimalMapper.toBD(animalDTO);
        this.animalJPARepository.save(animal);

    }

    public void delete(AnimalDTO animalDTO){
        Animal animal = AnimalMapper.toBD(animalDTO);
        this.animalJPARepository.delete(animal);

    }
}
