package edu.cibertec.curso.service;

import edu.cibertec.curso.dao.CursoEntity;

import java.util.List;

public interface CursoService {
    public List<CursoEntity> listarTodos();
    public CursoEntity obtenerUno(int codigo);
    public void insertar(CursoEntity ce);
    public void modificar(CursoEntity ce);
    public void eliminar(int codigo);
}
