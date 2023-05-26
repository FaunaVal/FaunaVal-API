package com.faunaval.api.rest.controller;

import com.faunaval.api.rest.dto.FotoDTO;
import com.faunaval.api.rest.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class FotoController {

    @Autowired
    FotoService fotoService;

    @GetMapping("/count")
    public Long count() {
        return this.fotoService.count();
    }

    @GetMapping("")
    public List<FotoDTO> findAll() {
        return this.fotoService.findAll();
    }

    @GetMapping("/{id}")
    public FotoDTO findById(@PathVariable Long id) {
        FotoDTO fotoDTO = this.fotoService.findById(id);
        if (fotoDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
        return fotoDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public FotoDTO create(@RequestBody FotoDTO fotoDTO) {
        return this.fotoService.create(fotoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void update(@PathVariable int id, @RequestBody FotoDTO fotoDTO) {
        if (id != fotoDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.fotoService.update(fotoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void delete(@PathVariable int id, @RequestBody FotoDTO fotoDTO) {
        if (id != fotoDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.fotoService.delete(fotoDTO);
    }
}
