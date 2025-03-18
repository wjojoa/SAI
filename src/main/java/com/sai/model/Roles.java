package com.sai.model;
import jakarta.persistence.*;

@Entity
@Table(name="rol")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private Integer idRol;

    private String nombre;
    private boolean estado;


}

