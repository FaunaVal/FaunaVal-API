package com.faunaval.api.rest.controller;

import com.faunaval.api.rest.dto.AnimalDTO;
import com.faunaval.api.rest.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/count")
    public Long count() {
        return this.animalService.count();
    }

    @GetMapping("")
    public List<AnimalDTO> findAll() {
        return this.animalService.findAll();
    }

    @GetMapping("/list/{id}")
    public List<AnimalDTO> findAllList(@PathVariable Long id) {
        return this.animalService.findAllListInfo(id);
    }

    @GetMapping("/{id}")
    public AnimalDTO findById(@PathVariable Long id) {
        AnimalDTO animalDTO = this.animalService.findByIdWithInfo(id);
        if (animalDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
        return animalDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AnimalDTO create(@RequestBody AnimalDTO animalDTO) {
        return this.animalService.create(animalDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void update(@PathVariable int id, @RequestBody AnimalDTO animalDTO) {
        if (id != animalDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.animalService.update(animalDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void delete(@PathVariable int id, @RequestBody AnimalDTO animalDTO) {
        if (id != animalDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.animalService.delete(animalDTO);
    }
}
