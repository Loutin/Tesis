package com.apiTesis.Crud.Requests;

// Clase para representar datos de la solicitud HTTP
public class AnimalRequest {

    private Integer caravana;
    private String raza;
    private Integer edad;
    private String sexo;
    private Float peso;
    private Integer idMedicamentoAplicado;
    private Integer idRodeo;

    public AnimalRequest() {
    }


    public Integer getCaravana() {
        return this.caravana;
    }

    public void setCaravana(Integer caravana) {
        this.caravana = caravana;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Float getPeso() {
        return this.peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getIdMedicamentoAplicado() {
        return this.idMedicamentoAplicado;
    }

    public void setIdMedicamentoAplicado(Integer idMedicamentoAplicado) {
        this.idMedicamentoAplicado = idMedicamentoAplicado;
    }

    public Integer getIdRodeo() {
        return this.idRodeo;
    }

    public void setIdRodeo(Integer idRodeo) {
        this.idRodeo = idRodeo;
    }

    
}