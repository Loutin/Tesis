package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.ToolModel;
import com.apiTesis.Crud.repositories.IToolRepository;

@Service
public class ToolService{

    @Autowired
    IToolRepository toolRepository;

    public ArrayList<ToolModel> getToolById() {
        return (ArrayList<ToolModel>) toolRepository.findAll();
    }
    
    public ToolModel saveToolById(ToolModel tool) {
        return toolRepository.save(tool);
    }
    
    public Optional<ToolModel> getToolById(Integer ID_Herramienta) {
        if (ID_Herramienta == null) {
            // Manejo del error cuando ID_Herramienta es null
            throw new IllegalArgumentException("El ID_Herramienta no puede ser nulo");
        }
        
        return toolRepository.findById(ID_Herramienta);
    }
    
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public ToolModel updateToolById(ToolModel request, Integer ID_Herramienta) {
        Optional<ToolModel> optionalTool = toolRepository.findById(ID_Herramienta);
        if (optionalTool.isPresent()) {
            ToolModel toolModel = optionalTool.get();
            if (request.getIdHerramienta() != null) {
                toolModel.setIdHerramienta(request.getIdHerramienta());
            }
            if (request.getNombre() != null) {
                toolModel.setNombre(request.getNombre());
            }
            if (request.getTipo() != null) {
                toolModel.setTipo(request.getTipo());
            }
            if (request.getDescripcion() != null) {
                toolModel.setDescripcion(request.getDescripcion());
            }
            if (request.getCantidadDisponible() != null) {
                toolModel.setCantidadDisponible(request.getCantidadDisponible());
            }
            toolRepository.save(toolModel);
            return toolModel;
        } else {
            // Manejar el caso en el que la herramienta no se encuentra en la base de datos.
            throw new NoSuchElementException("Herramienta no encontrada con ID: " + ID_Herramienta);
        }
    }

    public Boolean deleteToolById(Integer ID_Herramienta) {
        try{
            toolRepository.deleteById(ID_Herramienta);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
