package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.ClientModel;
import com.apiTesis.Crud.repositories.IClientRepository;

@Service
public class ClientService{

    @Autowired
    IClientRepository clientRepository;

    public ArrayList<ClientModel> getClientById() {
        return (ArrayList<ClientModel>) clientRepository.findAll();
    }
    
    public ClientModel saveClientById(ClientModel cliente) {
        return clientRepository.save(cliente);
    }
    
    public Optional<ClientModel> getClientById(Integer ID_Cliente) {
        if (ID_Cliente == null) {
            // Manejo del error cuando ID_Cliente es null
            throw new IllegalArgumentException("El ID_Cliente no puede ser nulo");
        }
        
        return clientRepository.findById(ID_Cliente);
    }
    

    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public ClientModel updateClientById(ClientModel request, Integer ID_Cliente) {
        Optional<ClientModel> optionalClient = clientRepository.findById(ID_Cliente);
        if (optionalClient.isPresent()) {
            ClientModel clientModel = optionalClient.get();
            if (request.getIdCliente() != null) {
                clientModel.setIdCliente(request.getIdCliente());
            }
            if (request.getNombre() != null) {
                clientModel.setNombre(request.getNombre());
            }
            if (request.getEmpresa() != null) {
                clientModel.setEmpresa(request.getEmpresa());
            }
            if (request.getTelefono() != null) {
                clientModel.setTelefono(request.getTelefono());
            }
            if (request.getDireccion() != null) {
                clientModel.setDireccion(request.getDireccion());
            }
            if (request.getCorreoElectronico() != null) {
                clientModel.setCorreoElectronico(request.getCorreoElectronico());
            }
            clientRepository.save(clientModel);
            return clientModel;
        } else {
            // Manejar el caso en el que el cliente no se encuentra en la base de datos.
            throw new NoSuchElementException("Cliente no encontrado con ID: " + ID_Cliente);
        }
    }

    

    public Boolean deleteClientById(Integer ID_Cliente) {
        try{
            clientRepository.deleteById(ID_Cliente);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
