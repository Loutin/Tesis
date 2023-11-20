package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.ToolModel;
import com.apiTesis.Crud.services.ToolService;

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
@RequestMapping("/Tool")    //Ruta para acceder a las funcionalidades

public class ToolController {

	@Autowired
	private ToolService ToolService;
	
	@GetMapping
	public ArrayList<ToolModel> getToolById() {
		return this.ToolService.getToolById();
    }

    @PostMapping
    public ToolModel saveToolById(@RequestBody ToolModel herramienta) {
        return this.ToolService.saveToolById(herramienta);
    }

    @GetMapping(path = "/{ID_Herramienta}")
    public Optional<ToolModel> getToolById(@PathVariable Integer ID_Herramienta) {
        return this.ToolService.getToolById(ID_Herramienta);
    }
    
    @PutMapping(path = "/{ID_Herramienta}")
    public ToolModel updateToolById(@RequestBody ToolModel request ,@PathVariable Integer ID_Herramienta){
        return this.ToolService.updateToolById(request, ID_Herramienta);   
    }
    
    @DeleteMapping(path = "/{ID_Herramienta}")
    public String deleteToolById(@PathVariable("ID_Herramienta") Integer ID_Herramienta) {
        boolean ok = this.ToolService.deleteToolById(ID_Herramienta);

        if(ok){
            return "La heramienta: " + ID_Herramienta + " ha sido eliminada";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar la heramienta: " + ID_Herramienta;
        }
    }
}