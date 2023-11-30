package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.Requests.AnimalRequest;
import com.apiTesis.Crud.models.AnimalModel;
import com.apiTesis.Crud.repositories.IAnimalRepository;

@Service
public class AnimalService{

    @Autowired
    IAnimalRepository animalRepository;
    //private final MedicamentoRepository medicamentoRepository;
    //private final RodeoRepository rodeoRepository;

    @Autowired
    public AnimalService(IAnimalRepository animalRepository){//, MedicamentoRepository medicamentoRepository, RodeoRepository rodeoRepository) {
        this.animalRepository = animalRepository;
        //this.medicamentoRepository = medicamentoRepository;
        //this.rodeoRepository = rodeoRepository;
    }


    public AnimalModel registrarAnimal(AnimalRequest animalRequest) {
        AnimalModel animal = new AnimalModel();
        animal.setCaravana(animalRequest.getCaravana());
        animal.setRaza(animalRequest.getRaza());
        animal.setEdad(animalRequest.getEdad());
        animal.setSexo(animalRequest.getSexo());
        animal.setPesoCompra(animalRequest.getPeso());
        animal.setPesoActual(animalRequest.getPeso());

        // Guardar el animal primero para obtener su ID asignado
        AnimalModel animalGuardado = animalRepository.save(animal);

        // Cargar Medicamento y Rodeo usando sus IDs
        /*Medicamento medicamento = medicamentoRepository.findById(animalRequest.getIdMedicamentoAplicado())
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));

        Rodeo rodeo = rodeoRepository.findById(animalRequest.getIdRodeo())
                .orElseThrow(() -> new RuntimeException("Rodeo no encontrado"));

        // Asignar Medicamento y Rodeo al animal y actualizar en la base de datos
        animalGuardado.setMedicamentoAplicado(medicamento);
        animalGuardado.setRodeo(rodeo);*/
        return animalRepository.save(animalGuardado);
    }

    public ArrayList<AnimalModel> getAnimalById() {
        return (ArrayList<AnimalModel>) animalRepository.findAll();
    }
    
    public AnimalModel saveAnimalById(AnimalModel animal) {                 // ya esta
        return animalRepository.save(animal);
    }
    
    public Optional<AnimalModel> getAnimalById(Integer Caravana) {
        if (Caravana == null) {
            // Manejo del error cuando Caravana es null
            throw new IllegalArgumentException("La Caravana no puede ser nula");
        }
        
        return animalRepository.findById(Caravana);
    }
    
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public AnimalModel updateAnimalById(AnimalModel request, Integer Caravana) {
        Optional<AnimalModel> optionalAnimal = animalRepository.findById(Caravana);
        if (optionalAnimal.isPresent()) {
            AnimalModel animalModel = optionalAnimal.get();
            if (request.getCaravana() != null) {
                animalModel.setCaravana(request.getCaravana());
            }
            if (request.getIdMedicamentoAplicado() != null) {
                animalModel.setIdMedicamentoAplicado(request.getIdMedicamentoAplicado());
            }
            if (request.getIdRodeo() != null) {
                animalModel.setIdRodeo(request.getIdRodeo());
            }
            if (request.getRaza() != null) {
                animalModel.setRaza(request.getRaza());
            }
            if (request.getEdad() != null) {
                animalModel.setEdad(request.getEdad());
            }
            if (request.getSexo() != null) {
                animalModel.setSexo(request.getSexo());
            }
            if (request.getPesoCompra() != null) {
                animalModel.setPesoCompra(request.getPesoCompra());
            }
            if (request.getPesoActual() != null) {
                animalModel.setPesoActual(request.getPesoActual());
            }
            animalRepository.save(animalModel);
            return animalModel;
        } else {
            // Manejar el caso en el que el animal no se encuentre en la base de datos.
            throw new NoSuchElementException("Animal no encontrado con ID: " + Caravana);
        }
    } 

    public Boolean deleteAnimalById(Integer Caravana) {
        try{
            animalRepository.deleteById(Caravana);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
