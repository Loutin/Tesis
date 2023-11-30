package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.Requests.AnimalRequest;
import com.apiTesis.Crud.Requests.ApiResponse;
import com.apiTesis.Crud.models.AnimalModel;
import com.apiTesis.Crud.services.AnimalService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Animal") //Ruta para acceder a las funcionalidades

public class AnimalController {

	@Autowired
	private AnimalService AnimalService;
	
	@GetMapping
	public ArrayList<AnimalModel> getAnimalById() {
		return this.AnimalService.getAnimalById();
    }


    @PostMapping
    public ResponseEntity<Object> registrarAnimal(@RequestBody AnimalRequest animalRequest) {
        try {
            AnimalModel guardarAnimal = AnimalService.registrarAnimal(animalRequest);
            String mensaje = "Animal registrado correctamente con Caravana: " + guardarAnimal.getCaravana();
            return ResponseEntity.ok(new ApiResponse("success", mensaje));
        } catch (Exception e) {
            String mensaje = "Error al registrar el animal: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("error", mensaje));
        }
    }

    @PostMapping
    public AnimalModel saveAnimalById(@RequestBody AnimalModel animal) {
        return this.AnimalService.saveAnimalById(animal);
    }



    @GetMapping(path = "/{Caravana}")
    public ResponseEntity<Object> obtenerAnimalById(@PathVariable Integer Caravana) {
        try {
            Optional<AnimalModel> obtenerAnimal = AnimalService.getAnimalById(Caravana);

            if (obtenerAnimal.isPresent()) {
                AnimalModel animal = obtenerAnimal.get();
                String mensaje = "El número de caravana de este animal: " + animal.getCaravana();       //Revisar el mensaje de respuesta
                return ResponseEntity.ok(new ApiResponse("success", mensaje));
            } else {
                // No se encuentra el animal
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            String mensaje = "Error al obtener el animal: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("error", mensaje)); //Revisar el mensaje
        }
    }

    @GetMapping(path = "/{Caravana}")
    public Optional<AnimalModel> getAnimalById(@PathVariable Integer Caravana) {
        return this.AnimalService.getAnimalById(Caravana);
    }
    


    @PutMapping(path = "/{Caravana}")
    public ResponseEntity<Object> actualizarAnimalById(@RequestBody AnimalModel request, @PathVariable Integer Caravana) {
        try {
            AnimalModel updatedAnimal = AnimalService.updateAnimalById(request, Caravana);

            if (updatedAnimal != null) {
                String mensaje = "Animal actualizado correctamente con número de caravana: " + Caravana;
                return ResponseEntity.ok(new ApiResponse("success", mensaje));
            } else {
                return ResponseEntity.notFound().build();       //es un 404
            }
        } catch (Exception e) {
            String mensaje = "Error al actualizar el animal: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("error", mensaje));
        }
    }


    @PutMapping(path = "/{Caravana}")
    public AnimalModel updateAnimalById(@RequestBody AnimalModel request ,@PathVariable Integer Caravana){
        return this.AnimalService.updateAnimalById(request, Caravana);   
    }
    



    @DeleteMapping(path = "/{Caravana}")
    public ResponseEntity<Object> eliminarAnimalById(@PathVariable("Caravana") Integer Caravana) {
        try {
            boolean deleted = AnimalService.deleteAnimalById(Caravana);

            if (deleted) {
                String mensaje = "El animal con número de caravana " + Caravana + " ha sido eliminado correctamente.";
                return ResponseEntity.ok(new ApiResponse("success", mensaje));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            String mensaje = "Error al eliminar el animal: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("error", mensaje));
        }
    }


    @DeleteMapping(path = "/{Caravana}")
    public String deleteAnimalById(@PathVariable("Caravana") Integer Caravana) {
        boolean ok = this.AnimalService.deleteAnimalById(Caravana);

        if(ok){
            return "El animal: " + Caravana + " ha sido eliminado";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar el animal: " + Caravana;
        }
    }
}

