package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.RodeoModel;
import com.apiTesis.Crud.repositories.IRodeoRepository;

@Service
public class RodeoService {

    @Autowired
    IRodeoRepository rodeoRepository;

    public ArrayList<RodeoModel> getRodeoById() {
        return (ArrayList<RodeoModel>) rodeoRepository.findAll();
    }

    public RodeoModel saveRodeoById(RodeoModel rodeo) {
        return rodeoRepository.save(rodeo);
    }

    public Optional<RodeoModel> getRodeoById(Integer ID_Rodeo) {
        return rodeoRepository.findById(ID_Rodeo);
    }

    public RodeoModel updateRodeoById(RodeoModel request, Integer ID_Rodeo) {
        Optional<RodeoModel> optionalRodeo = rodeoRepository.findById(ID_Rodeo);
        if (optionalRodeo.isPresent()) {
            RodeoModel rodeoModel = optionalRodeo.get();
            if (request.getIdRodeo() != null) {
                rodeoModel.setIdRodeo(request.getIdRodeo());
            }
            if (request.getCaravana() != null) {
                rodeoModel.setCaravana(request.getCaravana());
            }
            if (request.getNumero_Campo() != null) {
                rodeoModel.setNumero_Campo(request.getNumero_Campo());
            }
            rodeoRepository.save(rodeoModel);
            return rodeoModel;
        } else {
            // Manejar el caso en el que el rodeo no se encuentra en la base de datos.
            throw new NoSuchElementException("Rodeo no encontrado con ID: " + ID_Rodeo);
        }
    }

    public Boolean deleteRodeoById(Integer ID_Rodeo) {
        try {
            rodeoRepository.deleteById(ID_Rodeo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


