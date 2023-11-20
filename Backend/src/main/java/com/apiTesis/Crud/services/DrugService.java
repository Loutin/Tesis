package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.DrugModel;
import com.apiTesis.Crud.repositories.IDrugRepository;

@Service
public class DrugService{

    @Autowired
    IDrugRepository drugRepository;

    public ArrayList<DrugModel> getDrugById() {
        return (ArrayList<DrugModel>) drugRepository.findAll();
    }
    
    public DrugModel saveDrugById(DrugModel Medicamentoaplicado) {
        return drugRepository.save(Medicamentoaplicado);
    }
    
    public Optional<DrugModel> getDrugById(Integer ID_Medicamentoaplicado) {
        if (ID_Medicamentoaplicado == null) {
            // Manejo del error cuando ID_Medicamentoaplicado es null
            throw new IllegalArgumentException("El ID_Medicamentoaplicado no puede ser nulo");
        }
        
        return drugRepository.findById(ID_Medicamentoaplicado);
    }
    
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public DrugModel updateDrugById(DrugModel request, Integer ID_Medicamentoaplicado) {
        Optional<DrugModel> optionalDrug = drugRepository.findById(ID_Medicamentoaplicado);
        if (optionalDrug.isPresent()) {
            DrugModel drugModel = optionalDrug.get();
            if (request.getIdMedicamentoaplicado() != null) {
                drugModel.setIdMedicamentoaplicado(request.getIdMedicamentoaplicado());
            }
            if (request.getCaravana() != null) {
                drugModel.setCaravana(request.getCaravana());
            }
            if (request.getIdMedicamento() != null) {
                drugModel.setIdMedicamento(request.getIdMedicamento());
            }
            if (request.getIdActividad() != null) {
                drugModel.setIdActividad(request.getIdActividad());
            }
            if (request.getCantidadAplicada() != null) {
                drugModel.setCantidadAplicada(request.getCantidadAplicada());
            }
            if (request.getFechaAplicacion() != null) {
                drugModel.setFechaAplicacion(request.getFechaAplicacion());
            }
            if (request.getFechaProximaAplicacion() != null) {
                drugModel.setFechaProximaAplicacion(request.getFechaProximaAplicacion());
            }
            drugRepository.save(drugModel);
            return drugModel;
        } else {
            // Manejar el caso en el que la medicamento aplicado no se encuentra en la base de datos.
            throw new NoSuchElementException("Medicamento aplicado no encontrado con ID: " + ID_Medicamentoaplicado);
        }
    }
    

    public Boolean deleteDrugById(Integer ID_Medicamentoaplicado) {
        try{
            drugRepository.deleteById(ID_Medicamentoaplicado);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
