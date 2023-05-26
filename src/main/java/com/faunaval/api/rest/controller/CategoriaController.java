package com.faunaval.api.rest.controller;

import com.faunaval.api.rest.dto.CategoriaDTO;
import com.faunaval.api.rest.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/count")
    public Long count() {
        return this.categoriaService.count();
    }

    @GetMapping("")
    public List<CategoriaDTO> findAll() {
        return this.categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO findById(@PathVariable Long id) {
        CategoriaDTO categoriaDTO = this.categoriaService.findById(id);
        if (categoriaDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
        return categoriaDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoriaDTO create(@RequestBody CategoriaDTO categoriaDTO) {
        return this.categoriaService.create(categoriaDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void update(@PathVariable int id, @RequestBody CategoriaDTO categoriaDTO) {
        if (id != categoriaDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.categoriaService.update(categoriaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void delete(@PathVariable int id, @RequestBody CategoriaDTO categoriaDTO) {
        if (id != categoriaDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.categoriaService.delete(categoriaDTO);
    }
}
