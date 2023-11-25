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
    public Optional<AnimalModel> getAnimalById(@PathVariable Integer Caravana) {
        return this.AnimalService.getAnimalById(Caravana);
    }
    
    @PutMapping(path = "/{Caravana}")
    public AnimalModel updateAnimalById(@RequestBody AnimalModel request ,@PathVariable Integer Caravana){
        return this.AnimalService.updateAnimalById(request, Caravana);   
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

