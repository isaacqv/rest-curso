package edu.cibertec.curso.dao.repository;

import edu.cibertec.curso.dao.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity,Integer> {

}
