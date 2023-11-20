package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.DrugModel;
import com.apiTesis.Crud.services.DrugService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Drug") //Ruta para acceder a las funcionalidades

public class DrugController {

	@Autowired
	private DrugService drugService;
	
	@GetMapping
	public ArrayList<DrugModel> getDrugById() {
		return this.drugService.getDrugById();
    }

    @PostMapping
    public DrugModel saveDrugById(@RequestBody DrugModel Medicamentoaplicado) {
        return this.drugService.saveDrugById(Medicamentoaplicado);
    }

    @GetMapping(path = "/{ID_Medicamentoaplicado}")
    public Optional<DrugModel> getDrugById(@PathVariable Integer ID_Medicamentoaplicado) {
        return this.drugService.getDrugById(ID_Medicamentoaplicado);
    }
    
    @PutMapping(path = "/{ID_Medicamentoaplicado}")
    public DrugModel updateDrugById(@RequestBody DrugModel request ,@PathVariable Integer ID_Medicamentoaplicado){
        return this.drugService.updateDrugById(request, ID_Medicamentoaplicado);   
    }
    
    @DeleteMapping(path = "/{ID_Medicamentoaplicado}")
    public String deleteDrugById(@PathVariable("ID_Medicamentoaplicado") Integer ID_Medicamentoaplicado) {
        boolean ok = this.drugService.deleteDrugById(ID_Medicamentoaplicado);

        if(ok){
            return "El medicamentoaplicado: " + ID_Medicamentoaplicado + " ha sido eliminado";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar el medicamentoaplicado: " + ID_Medicamentoaplicado;
        }
    }
}

