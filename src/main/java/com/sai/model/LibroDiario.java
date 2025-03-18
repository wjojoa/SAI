package com.sai.model;

import jakarta.persistence.*;
import org.springframework.objenesis.instantiator.basic.ObjectInputStreamInstantiator;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "librodiario")
public class LibroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fecha;
    private String concepto;
    private Double ingreso;
    private Double egreso;
    private Double saldo;


    public LibroDiario() {

    }

    public LibroDiario(String fecha, String concepto, Double ingreso, Double egreso, Double saldo) {

        this.fecha = fecha;
        this.concepto = concepto;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.saldo = saldo;
        actualizarSaldo();
    }

    private void actulizarSaldo() {
    }

    /*public void actualizarSaldo() {
        if (ingreso != null) {
            saldo += ingreso;
        }
        if (egreso != null) {
            saldo -= egreso;
        }
    }*/

    public void actualizarSaldo() {
        if (saldo == null) {
            saldo = 0.0; // Inicializa saldo si es null
        }
        saldo += (ingreso != null ? ingreso : 0.0);
        saldo -= (egreso != null ? egreso : 0.0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getIngreso() {
        return ingreso;
    }

    public void setIngreso(Double ingreso) {
        this.ingreso = ingreso;
        actualizarSaldo();
    }

    public Double getEgreso() {
        return egreso;
    }

    public void setEgreso(Double egreso) {
        this.egreso = egreso;
        actualizarSaldo();
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
