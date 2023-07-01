package edu.cibertec.curso.controller;

import edu.cibertec.curso.dao.CursoEntity;
import edu.cibertec.curso.dto.ErrorDTO;
import edu.cibertec.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @ExceptionHandler(Exception.class)
    private ResponseEntity manejarExcepciones(){
        ErrorDTO err = new ErrorDTO(HttpStatus.CONFLICT.toString(), "Problema interno",
                "Ha ocurrido un error en la aplicacion. Verifique su request");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @GetMapping("/cursos")
    List<CursoEntity> listarTodos(){
        return cursoService.listarTodos();
    }
    @GetMapping("/cursos/{id}")
    public CursoEntity obtenerUno(@PathVariable(value = "id") int codigo){
        try {
            return cursoService.obtenerUno(codigo);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso no localizado",e);
        }
    }
    @PostMapping("/curso")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody CursoEntity ce){
        try {
            cursoService.insertar(ce);
        } catch (DataIntegrityViolationException ex){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Curso no pudo ser creado", ex);
        }
    }
    @PutMapping("cursos/{id}")
    public void modificar(@RequestBody CursoEntity ce, @PathVariable(value = "id") int codigo){
        ce.setIdcurso(codigo);
        cursoService.modificar(ce);
    }
    @DeleteMapping("cursos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable(value = "id") int codigo){
        cursoService.eliminar(codigo);
    }
}
