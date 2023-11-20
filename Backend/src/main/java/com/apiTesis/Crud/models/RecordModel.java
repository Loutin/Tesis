package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial_actividades")
public class RecordModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Actividadrealizada;

    @Column
    private Integer ID_Actividad;
    
    @Column
    private Integer ID_Empleado;

    @Column
    private Integer ID_Rodeo;

    @Column
    private String Tipo;

    @Column
    private String Fecha_Finalizacion; //Mas adelante definir como hacer para ponerlo como tipo fecha

    @Column
    private String Descripcion;

    @Column
    private String Tiempo_Realizacion;

    public Integer getIdActividadRealizada() {
        return ID_Actividadrealizada;
    }

    public void setIdActividadRealizada(Integer ID_Actividadrealizada) {
        this.ID_Actividadrealizada = ID_Actividadrealizada;
    }

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


    public Integer getIdRodeo() {
        return ID_Rodeo;
    }

    public void setIdRodeo(Integer ID_Rodeo) {
        this.ID_Rodeo = ID_Rodeo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getFechaFinalizacion() {
        return Fecha_Finalizacion;
    }

    public void setFechaFinalizacion(String Fecha_Finalizacion) {
        this.Fecha_Finalizacion = Fecha_Finalizacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTiempoRealizacion() {
        return Tiempo_Realizacion;
    }

    public void setTiempoRealizacion(String Tiempo_Realizacion) {
        this.Tiempo_Realizacion = Tiempo_Realizacion;
    }
}