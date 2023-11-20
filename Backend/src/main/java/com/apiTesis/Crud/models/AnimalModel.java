package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Caravana;

    @Column
    private Integer ID_MedicamentoAplicado;

    @Column
    private Integer ID_Rodeo;

    @Column
    private String Raza;

    @Column
    private Integer Edad;

    @Column
    private String Sexo; 

    @Column
    private Float Peso_Compra;

    @Column
    private Float Peso_Actual;

    public Integer getCaravana() {
        return Caravana;
    }

    public void setCaravana(Integer Caravana) {
        this.Caravana = Caravana;
    }

    public Integer getIdMedicamentoAplicado() { 
        return ID_MedicamentoAplicado;
    }

    public void setIdMedicamentoAplicado(Integer ID_MedicamentoAplicado) {
        this.ID_MedicamentoAplicado = ID_MedicamentoAplicado;
    }

    public Integer getIdRodeo() {
        return ID_Rodeo;
    }

    public void setIdRodeo(Integer ID_Rodeo) {
        this.ID_Rodeo = ID_Rodeo;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Float getPesoCompra() {
        return Peso_Compra;
    }

    public void setPesoCompra(Float Peso_Compra) {
        this.Peso_Compra = Peso_Compra;
    }

    public Float getPesoActual() {
        return Peso_Actual;
    }

    public void setPesoActual(Float Peso_Actual) {
        this.Peso_Actual = Peso_Actual;
    }
}