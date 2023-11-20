package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actividad")
public class ActivityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Actividad;

    @Column
    private Integer ID_Empleado;

    @Column
    private String Tipo;

    @Column
    private String Descripcion;

    @Column
    private String Fecha_Inicio; //Mas adelante definir como hacer para ponerlo como tipo fecha

    @Column
    private String Fecha_Finalizacion;

    public Integer getIdActividad() {
        return ID_Actividad;
    }

    public void setIdActividad(Integer ID_Actividad) {
        this.ID_Actividad = ID_Actividad;
    }

     public Integer getIdEmpleado() {
        return ID_Empleado;
    }

    public void setIdEmpleado(Integer ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
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

    public String getFechaInicio() {
        return Fecha_Inicio;
    }

    public void setFechaInicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFechaFinalizacion() {
        return Fecha_Finalizacion;
    }

    public void setFechaFinalizacion(String Fecha_Finalizacion) {
        this.Fecha_Finalizacion = Fecha_Finalizacion;
    }
}