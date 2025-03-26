package com.sai.model;

import jakarta.persistence.*;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpersona")
    private Integer idPersona;
    private Integer documento;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String direccion;
    private String email;
    private String estadocivil;
    private Integer hijos;
    private String fechabautismo;
    private Boolean promesado;

    public Persona(Integer idPersona, Integer documento, String nombre, String apellido, Integer telefono, String direccion, String email, String estadocivil, Integer hijos, String fechabautismo, Boolean promesado) {
        this.idPersona = idPersona;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estadocivil = estadocivil;
        this.hijos = hijos;
        this.fechabautismo = fechabautismo;
        this.promesado = promesado;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Integer getHijos() {
        return hijos;
    }

    public void setHijos(Integer hijos) {
        this.hijos = hijos;
    }

    public String getFechabautismo() {
        return fechabautismo;
    }

    public void setFechabautismo(String fechabautismo) {
        this.fechabautismo = fechabautismo;
    }

    public Boolean getPromesado() {
        return promesado;
    }

    public void setPromesado(Boolean promesado) {
        this.promesado = promesado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", estadocivil='" + estadocivil + '\'' +
                ", hijos=" + hijos +
                ", fechabautismo='" + fechabautismo + '\'' +
                ", promesado=" + promesado +
                '}';
    }
}
