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

    }

    private void actulizarSaldo() {
    }


    public LibroDiario actualizarSaldo(Double saldo , LibroDiario libroDiarioRequest) {
      libroDiarioRequest.setSaldo(libroDiarioRequest.getIngreso() != null
              ? saldo + libroDiarioRequest.getIngreso()
              : saldo - libroDiarioRequest.getEgreso()); //puede quedar saldo negativo - hay que hacer validacion
      return libroDiarioRequest;
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
//        actualizarSaldo();
    }

    public Double getEgreso() {
        return egreso;
    }

    public void setEgreso(Double egreso) {
        this.egreso = egreso;
//        actualizarSaldo();
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "LibroDiario{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", concepto='" + concepto + '\'' +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                ", saldo=" + saldo +
                '}';
    }
}
