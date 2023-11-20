package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rodeo")
public class RodeoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Rodeo;


    @Column
    private Integer Caravana;


    @Column
    private Integer Numero_Campo;
    
    public Integer getIdRodeo() {
        return ID_Rodeo;
    }

    public void setIdRodeo(Integer ID_Rodeo) {
        this.ID_Rodeo = ID_Rodeo; 
    }

    /**
     * @return the caravana
     */
    public Integer getCaravana() {
        return Caravana;
    }

    /**
     * @param caravana the caravana to set
     */
    public void setCaravana(Integer Caravana) {
        this.Caravana = Caravana;
    }

    /**
     * @return the numero_Campo
     */
    public Integer getNumero_Campo() {
        return Numero_Campo;
    }

    /**
     * @param numero_Campo the numero_Campo to set
     */
    public void setNumero_Campo(Integer Numero_Campo) {
        this.Numero_Campo = Numero_Campo;
    }
}