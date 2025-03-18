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
    private Float ingreso;
    private Float egreso;
    private Float saldo;


    public LibroDiario() {

    }

    public LibroDiario(String fecha, String concepto, Float ingreso, Float egreso, Float saldo) {

        this.fecha = fecha;
        this.concepto = concepto;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.saldo = saldo;
        actulizarSaldo();
    }

    private void actulizarSaldo() {
    }

    public void actualizarSaldo() {
        if (ingreso != null) {
            saldo += ingreso;
        }
        if (egreso != null) {
            saldo -= egreso;
        }
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

    public Float getIngreso() {
        return ingreso;
    }

    public void setIngreso(Float ingreso) {
        this.ingreso = ingreso;
        actulizarSaldo();
    }

    public Float getEgreso() {
        return egreso;
    }

    public void setEgreso(Float egreso) {
        this.egreso = egreso;
        actulizarSaldo();
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}
