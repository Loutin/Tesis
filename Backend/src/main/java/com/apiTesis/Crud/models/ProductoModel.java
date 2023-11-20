package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Producto;

    @Column
    private String Categoria;

    @Column
    private String Nombre;

    @Column
    private String Tipo;

    @Column
    private String Descripcion;
    
    @Column
    private String  Marca;

    @Column
    private String Fecha_Vencimiento;

    public void setIdProducto(Integer iD_Producto) {
        ID_Producto = iD_Producto;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public void setFechaVencimiento(String fecha_Vencimiento) {
        Fecha_Vencimiento = fecha_Vencimiento;
    }

    public Integer getIdProducto() {
        return ID_Producto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public String getFechaVencimiento() {
        return Fecha_Vencimiento;
    }

}

