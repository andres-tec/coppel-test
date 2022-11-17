package com.coppeltestmg.coppeltest2.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity

@Table(name="usuarios")//establece el nombre de la tabla
@SQLDelete(sql = "UPDATE usuarios SET deleted = true WHERE uuid=?")
@Where(clause = "deleted= false")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uuid", unique = true, nullable = false)
    private Long uuid;
    private String nombre;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private Integer edad;
    private String Correo_Electronico;
    private String Telefono;
    @Column(name = "direccion_id",nullable = false)
    private Long Direccion_Id;

    private boolean deleted = Boolean.FALSE;
    public Usuarios(){}

    public Usuarios(Long uuid,
                    String nombre, String apellido_Paterno,
                    String apellido_Materno, Integer edad, String correo_Electronico,
                    String telefono, Long direccion_Id) {
        this.uuid = uuid;
        this.nombre = nombre;
        Apellido_Paterno = apellido_Paterno;
        Apellido_Materno = apellido_Materno;
        this.edad = edad;
        Correo_Electronico = correo_Electronico;
        Telefono = telefono;
        Direccion_Id = direccion_Id;
    }

    public Long getUuid() {
        return uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public Long getDireccion_Id() {
        return Direccion_Id;
    }
    //setters del model Usuarios
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        Apellido_Paterno = apellido_Paterno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        Apellido_Materno = apellido_Materno;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        Correo_Electronico = correo_Electronico;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public void setDireccion_Id(Long direccion_Id) {
        Direccion_Id = direccion_Id;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "uuid=" + uuid +
                ", Nombre='" + nombre + '\'' +
                ", Apellido_Paterno='" + Apellido_Paterno + '\'' +
                ", Apellido_Materno='" + Apellido_Materno + '\'' +
                ", edad=" + edad +
                ", Correo_Electronico='" + Correo_Electronico + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Direccion_Id=" + Direccion_Id +
                '}';
    }
}