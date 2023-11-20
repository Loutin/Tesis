package com.apiTesis.Crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "credenciales_usuario")
public class CredentialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Usuario;

    @Column
    private String Usuario;

    @Column
    private String Contraseña;

    public Integer getIdUsuario() {
        return ID_Usuario;
    }

    public void setIdUsuario(Integer ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

     public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }


    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

}