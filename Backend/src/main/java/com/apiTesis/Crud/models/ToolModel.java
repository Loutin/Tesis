package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "herramienta")
public class ToolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Herramienta;

    @Column
    private String Nombre;

    @Column
    private String Tipo;

    @Column
    private String Descripcion;

    @Column
    private Integer Cantidad_Disponible; 

    public Integer getIdHerramienta() {
        return ID_Herramienta;
    }

    public void setIdHerramienta(Integer ID_Herramienta) {
        this.ID_Herramienta = ID_Herramienta;
    }

     public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getCantidadDisponible() {
        return Cantidad_Disponible;
    }

    public void setCantidadDisponible(Integer Cantidad_Disponible) {
        this.Cantidad_Disponible = Cantidad_Disponible;
    }
}