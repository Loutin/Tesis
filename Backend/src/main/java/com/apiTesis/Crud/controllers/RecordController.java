package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.RecordModel;
import com.apiTesis.Crud.services.RecordService;

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
@RequestMapping("/Record") //Ruta para acceder a las funcionalidades

public class RecordController {

	@Autowired
	private RecordService recordService;

	@GetMapping
	public ArrayList<RecordModel> getRecordById() {
		return this.recordService.getRecordById();
    }

    @PostMapping
    public RecordModel saveRecordById(@RequestBody RecordModel actividad_realizada) {
        return this.recordService.saveRecordById(actividad_realizada);
    }

    @GetMapping(path = "/{ID_ActividadRealizada}")
    public Optional<RecordModel> getRecordById(@PathVariable Integer ID_ActividadRealizada) {
        return this.recordService.getRecordById(ID_ActividadRealizada);
    }
    
    @PutMapping(path = "/{ID_ActividadRealizada}")
    public RecordModel updateRecordById(@RequestBody RecordModel request ,@PathVariable Integer ID_ActividadRealizada){
        return this.recordService.updateRecordById(request, ID_ActividadRealizada);   
    }
    
    @DeleteMapping(path = "/{ID_ActividadRealizada}")
    public String deleteRecordById(@PathVariable("ID_ActividadRealizada") Integer ID_ActividadRealizada) {
        boolean ok = this.recordService.deleteRecordById(ID_ActividadRealizada);

        if(ok){
            return "El registro historico de la actividad: " + ID_ActividadRealizada + " ha sido eliminada";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar el historial de la actividad: " + ID_ActividadRealizada;
        }
    }
}

