package com.procesocoppel.coppeltest.document;

import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "cuentasbancarias")
public class CuentasBancarias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private String id;
    private String nombreDeLaCuenta;
    private String banco;
    private String tipo;
    private double monto;
    @Column(name = "idUsuario", unique = false, nullable = false)
    private Long idUsuario;

    public CuentasBancarias(){}

    public CuentasBancarias(String id, String nombreDeLaCuenta, String banco, String tipo, double monto, Long idUsuario) {
        this.id = id;
        this.nombreDeLaCuenta = nombreDeLaCuenta;
        this.banco = banco;
        this.tipo = tipo;
        this.monto = monto;
        this.idUsuario = idUsuario;
    }

    public String getId() {
        return id;
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
        return "CuentasBancarias{" +
                "id='" + id + '\'' +
                ", nombreDeLaCuenta='" + nombreDeLaCuenta + '\'' +
                ", banco='" + banco + '\'' +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
