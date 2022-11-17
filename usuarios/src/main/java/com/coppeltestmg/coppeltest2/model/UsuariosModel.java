package com.coppeltestmg.coppeltest2.model;

import java.util.List;

public class UsuariosModel {

    private Long uuid;
    private String Nombre;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private Integer edad;
    private String Correo_Electronico;
    private String Telefono;

    private Long Direccion_Id;
    private List<Cuentas> cuentasbancarias;

    //constructor para generar un nuevo model
    public UsuariosModel(){}



    //getter de clase
    public String getNombre() {
        return Nombre;
    }
    public void setUuid(Long uuid) {
        this.uuid = uuid;
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

    public List<Cuentas> getCuentasbancarias() {
        return cuentasbancarias;
    }
    //setter de la clase


    public void setNombre(String nombre) {
        Nombre = nombre;
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

    public void setCuentasbancarias(List<Cuentas> cuentasbancarias) {
        this.cuentasbancarias = cuentasbancarias;
    }
    //toString de la clase
    @Override
    public String toString() {
        return "UsuariosModel{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido_Paterno='" + Apellido_Paterno + '\'' +
                ", Apellido_Materno='" + Apellido_Materno + '\'' +
                ", edad=" + edad +
                ", Correo_Electronico='" + Correo_Electronico + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Direccion_Id=" + Direccion_Id +
                ", cuentasbancarias=" + cuentasbancarias +
                '}';
    }
}