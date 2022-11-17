package com.coppeltestmg.coppeltest2.entity;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Direccion")
    private Long id_direccion;
    private String ciudad;
    private Integer codigo_postal;
    private String estado;

    //constructor de la clase
    public Direccion(){}
    public Direccion(Long id_direccion, String ciudad, Integer codigo_postal, String estado) {
        this.id_direccion = id_direccion;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.estado = estado;
    }
    //getters de todas las variables
    public Long getId_direccion() {
        return id_direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public String getEstado() {
        return estado;
    }
    //setters de todas nuestras variables


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //el toString de la clase
    @Override
    public String toString() {
        return "Direccion{" +
                "id_direccion=" + id_direccion +
                ", ciudad='" + ciudad + '\'' +
                ", codigo_postal=" + codigo_postal +
                ", estado='" + estado + '\'' +
                '}';
    }
}