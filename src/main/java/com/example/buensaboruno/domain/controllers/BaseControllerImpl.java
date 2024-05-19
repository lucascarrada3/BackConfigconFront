package com.example.buensaboruno.domain.controllers;

import com.example.buensaboruno.domain.entities.Base;
import com.example.buensaboruno.domain.services.BaseService;
import com.example.buensaboruno.domain.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl <T extends Base, S extends BaseServiceImpl<T, Long>> implements BaseController<T, Long>{
    @Autowired
    protected  S servicio;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, porfavor intente mas tarde\"}");
        }
    }
    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, porfavor intente mas tarde\"}");
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody T entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody T entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            servicio.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Eliminado Correctamente\"}");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }


}
