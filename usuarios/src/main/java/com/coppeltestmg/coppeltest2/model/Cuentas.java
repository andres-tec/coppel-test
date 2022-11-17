package com.coppeltestmg.coppeltest2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cuentas {
    private String id;
    private String nombreDeLaCuenta;

    private String banco;
    private String tipo;
    private double monto;
    private Long idUsuario;

    public Cuentas(){}
//setter and getter of the class


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreDeLaCuenta() {
        return nombreDeLaCuenta;
    }

    public void setNombreDeLaCuenta(String nombreDeLaCuenta) {
        this.nombreDeLaCuenta = nombreDeLaCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "CuentasBancariasModel{" +
                "nombreDeLaCuenta='" + nombreDeLaCuenta + '\'' +
                ", banco='" + banco + '\'' +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                ", idUsuario=" + idUsuario +
                '}';
    }
}