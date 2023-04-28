package com.faunaval.api.rest.controller.antiguo;

import com.faunaval.api.rest.dto.antiguo.SagaDTO;
import com.faunaval.api.rest.service.antiguo.SagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/sagas")
public class SagasController {

    @Autowired
    SagasService sagasService;

    @GetMapping("/count")
    public Long count(){
        return this.sagasService.count();
    }

    @GetMapping("")
    public List<SagaDTO> findAll(@RequestParam(required = false, defaultValue = "false")Boolean withPeliculas){
        return this.sagasService.findAll(withPeliculas);
    }

    @GetMapping("/{id}")
    public SagaDTO findById(@PathVariable Long id, @RequestParam(required = false, defaultValue = "false")Boolean withPeliculas){
        SagaDTO sagaDTO = this.sagasService.findById(id,withPeliculas);
        if(sagaDTO==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Entity not found");
        }
        return sagaDTO;
    }

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    public SagaDTO create(@RequestBody SagaDTO sagaDTO){
        return this.sagasService.create(sagaDTO,true);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT,reason = "Entity updated")
    public void update(@PathVariable int id, @RequestBody SagaDTO sagaDTO){
        if(id != sagaDTO.getId()){
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,"Error in query");
        }
        this.sagasService.update(sagaDTO,true);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT,reason = "Entity updated")
    public void delete(@PathVariable int id, @RequestBody SagaDTO sagaDTO){
        if(id != sagaDTO.getId()){
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,"Error in query");
        }
        this.sagasService.delete(sagaDTO,false);
    }
}
