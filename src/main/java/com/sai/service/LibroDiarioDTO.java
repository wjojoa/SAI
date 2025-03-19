package com.sai.service;

public class LibroDiarioDTO {

    private Integer id;
    private String fecha;
    private String concepto;
    private Double ingreso;
    private Double egreso;
    private Double saldo;

    public  LibroDiarioDTO(){

    }

    public LibroDiarioDTO(String fecha, String concepto, Double ingreso, Double egreso, Double saldo){
        this.concepto = fecha;
        this.concepto = concepto;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.saldo = saldo;

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
    }

    public Double getEgreso() {
        return egreso;
    }

    public void setEgreso(Double egreso) {
        this.egreso = egreso;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}


