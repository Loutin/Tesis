package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicamento_aplicado")
public class DrugModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Medicamentoaplicado;

    @Column
    private Integer Caravana;

    @Column
    private Integer ID_Medicamento;

    @Column
    private Integer ID_Actividad;

    @Column
    private Float Cantidad_Aplicada; //Mas adelante definir como hacer para ponerlo como tipo fecha

    @Column
    private String Fecha_Aplicacion;

    @Column
    private String Fecha_Proxima_aplicacion;

    public Integer getIdMedicamentoaplicado() {
        return ID_Medicamentoaplicado;
    }

    public void setIdMedicamentoaplicado(Integer ID_Medicamentoaplicado) {
        this.ID_Medicamentoaplicado = ID_Medicamentoaplicado;
    }

     public Integer getCaravana() {
        return Caravana;
    }

    public void setCaravana(Integer Caravana) {
        this.Caravana = Caravana;
    }


    public Integer getIdMedicamento() {
        return ID_Medicamento;
    }

    public void setIdMedicamento(Integer ID_Medicamento) {
        this.ID_Medicamento = ID_Medicamento;
    }

    public Integer getIdActividad() {
        return ID_Actividad;
    }

    public void setIdActividad(Integer ID_Actividad) {
        this.ID_Actividad = ID_Actividad;
    }

    public Float getCantidadAplicada() {
        return Cantidad_Aplicada;
    }

    public void setCantidadAplicada(Float Cantidad_Aplicada) {
        this.Cantidad_Aplicada = Cantidad_Aplicada;
    }

    public String getFechaAplicacion() {
        return Fecha_Aplicacion;
    }

    public void setFechaAplicacion(String Fecha_Aplicacion) {
        this.Fecha_Aplicacion = Fecha_Aplicacion;
    }

    public String getFechaProximaAplicacion() {
        return Fecha_Proxima_aplicacion;
    }

    public void setFechaProximaAplicacion(String Fecha_Proxima_aplicacion) {
        this.Fecha_Proxima_aplicacion = Fecha_Proxima_aplicacion;
    }
}