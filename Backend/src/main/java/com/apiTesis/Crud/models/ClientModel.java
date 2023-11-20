package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Cliente;

    @Column
    private String Nombre;

    @Column
    private String Empresa;

    @Column
    private Integer Telefono;

    @Column
    private String Direccion;

    @Column
    private String Correo_Electronico; 

    public Integer getIdCliente() {
        return ID_Cliente;
    }

    public void setIdCliente(Integer ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

     public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreoElectronico() {
        return Correo_Electronico;
    }

    public void setCorreoElectronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }
}