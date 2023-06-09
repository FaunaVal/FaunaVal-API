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

    public Long count() {
        return this.animalJPARepository.count();
    }

    public List<AnimalDTO> findAllListInfo(Long id) {
        List<Animal> animals = animalJPARepository.findAllListInfo(id);
        return AnimalMapper.toDTO(animals);
    }

    public List<AnimalDTO> findAllListInfoFiltered(Long id, String filter) {
        List<Animal> animals = animalJPARepository.findAllListInfoFiltered(id, filter);
        return AnimalMapper.toDTO(animals);
    }

    public AnimalDTO findByIdWithInfo(Long id) {
        Optional<Animal> animal = this.animalJPARepository.findByIdWithInfo(id);
        return AnimalMapper.toDTO(animal);
    }

    public List<AnimalDTO> findAll() {
        return AnimalMapper.toDTO(this.animalJPARepository.findAll());
    }

    public AnimalDTO create(AnimalDTO animalDTO) {
        Animal animal = AnimalMapper.toBD(animalDTO);
        animal = this.animalJPARepository.save(animal);
        return AnimalMapper.toDTO(animal);
    }

    public void update(AnimalDTO animalDTO) {
        Animal animal = AnimalMapper.toBD(animalDTO);
        this.animalJPARepository.save(animal);
    }

    public void delete(AnimalDTO animalDTO) {
        Animal animal = AnimalMapper.toBD(animalDTO);
        this.animalJPARepository.delete(animal);
    }
}
