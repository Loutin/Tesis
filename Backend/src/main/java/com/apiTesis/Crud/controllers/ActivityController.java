package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.ActivityModel;
import com.apiTesis.Crud.services.ActivityService;

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
@RequestMapping("/Activity") //Ruta para acceder a las funcionalidades

public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@GetMapping 
	public ArrayList<ActivityModel> getActivityById() {
		return this.activityService.getActivityById();
    }

    @PostMapping
    public ActivityModel saveActivityById(@RequestBody ActivityModel actividad) {
        return this.activityService.saveActivityById(actividad);
    }

    @GetMapping(path = "/{ID_Actividad}")
    public Optional<ActivityModel> getActivityById(@PathVariable Integer ID_Actividad) {
        return this.activityService.getActivityById(ID_Actividad);
    }
    
    @PutMapping(path = "/{ID_Actividad}")
    public ActivityModel updateActivityById(@RequestBody ActivityModel request ,@PathVariable Integer ID_Actividad){
        return this.activityService.updateActivityById(request, ID_Actividad);   
    }
    
    @DeleteMapping(path = "/{ID_Actividad}")
    public String deleteActivityById(@PathVariable("ID_Actividad") Integer ID_Actividad) {
        boolean ok = this.activityService.deleteActivityById(ID_Actividad);

        if(ok){
            return "La actividad: " + ID_Actividad + " ha sido eliminado";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar la actividad: " + ID_Actividad;
        }
    }
}

