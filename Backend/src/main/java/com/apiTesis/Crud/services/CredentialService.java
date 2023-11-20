package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.CredentialModel;
import com.apiTesis.Crud.repositories.ICredentialRepository;

@Service
public class CredentialService{

    @Autowired
    ICredentialRepository credentialRepository;

    public ArrayList<CredentialModel> getCredentialById() {
        return (ArrayList<CredentialModel>) credentialRepository.findAll();
    }
    
    public CredentialModel saveCredentialById(CredentialModel Usuario) {
        return credentialRepository.save(Usuario);
    }
    
    public Optional<CredentialModel> getCredentialById(Integer ID_Usuario) {
        if (ID_Usuario == null) {
            // Manejo del error cuando ID_Usuario es null
            throw new IllegalArgumentException("El ID_Usuario no puede ser nulo");
        }
        
        return credentialRepository.findById(ID_Usuario);
    }
    
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public CredentialModel updateCredentialById(CredentialModel request, Integer ID_Usuario) {
        Optional<CredentialModel> optionalCredential = credentialRepository.findById(ID_Usuario);
        if (optionalCredential.isPresent()) {
            CredentialModel credentialModel = optionalCredential.get();
            if (request.getIdUsuario() != null) {
                credentialModel.setIdUsuario(request.getIdUsuario());
            }
            if (request.getUsuario() != null) {
                credentialModel.setUsuario(request.getUsuario());
            }
            if (request.getContraseña() != null) {
                credentialModel.setContraseña(request.getContraseña());
            }
            credentialRepository.save(credentialModel);
            return credentialModel;
        } else {
            // Manejar el caso en el que la credencial no se encuentra en la base de datos.
            throw new NoSuchElementException("Credencial no encontrada con ID: " + ID_Usuario);
        }
    }
    

    public Boolean deleteCredentialById(Integer ID_Usuario) {
        try{
            credentialRepository.deleteById(ID_Usuario);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}

