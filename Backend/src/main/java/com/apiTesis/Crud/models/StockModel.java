package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class StockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Item;


    @Column
    private Integer Id_Producto;


    @Column
    private String Categoria;

    @Column
    private Integer Cantidad_Disponible;
    
    public Integer getIdItem() {
        return ID_Item;
    }

    public void setIdItem(Integer ID_Item) {
        this.ID_Item = ID_Item; 
    }

    public Integer getIdProducto() {
        return Id_Producto;
    }

    public void setIdProducto(Integer Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    
    public String getCategoria() {
        return Categoria;
    }


    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public Integer getCantidadDisponible() {
        return Cantidad_Disponible;
    }

    public void setCantidadDisponible(Integer Cantidad_Disponible) {
        this.Cantidad_Disponible = Cantidad_Disponible;
    }
}