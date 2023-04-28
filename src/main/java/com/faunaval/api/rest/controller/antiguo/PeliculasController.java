package com.faunaval.api.rest.controller.antiguo;

import com.faunaval.api.rest.dto.antiguo.PeliculaDTO;
import com.faunaval.api.rest.service.antiguo.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculasController {

    @Autowired
    PeliculasService peliculasService;

    @GetMapping("/count")
    public Long count() {
        return this.peliculasService.count();
    }

    @GetMapping("")
    public List<PeliculaDTO> findAll(@RequestParam(required = false, defaultValue = "false") Boolean withSagas) {
        return this.peliculasService.findAll(withSagas);
    }

    @GetMapping("/{id}")
    public PeliculaDTO findById(@PathVariable Long id, @RequestParam(required = false, defaultValue = "false") Boolean withSagas) {
        PeliculaDTO peliculaDTO = this.peliculasService.findById(id, withSagas);
        if (peliculaDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
        return peliculaDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PeliculaDTO create(@RequestBody PeliculaDTO peliculaDTO) {
        return this.peliculasService.create(peliculaDTO, true);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void update(@PathVariable int id, @RequestBody PeliculaDTO peliculaDTO) {
        if (id != peliculaDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.peliculasService.update(peliculaDTO, true);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void delete(@PathVariable int id, @RequestBody PeliculaDTO peliculaDTO) {
        if (id != peliculaDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error in query");
        }
        this.peliculasService.delete(peliculaDTO, false);

    }

}
