package edu.cibertec.curso.dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;
    private String nomcurso;
    private Date fechainicio;
    private Integer alumnosmin;
    private Integer alumnosact;
    private Integer estado;
}
