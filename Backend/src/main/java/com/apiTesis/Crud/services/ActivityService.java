package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.ActivityModel;
import com.apiTesis.Crud.repositories.IActivityRepository;

@Service
public class ActivityService{

    @Autowired
    IActivityRepository activityRepository;

    public ArrayList<ActivityModel> getActivityById() {
        return (ArrayList<ActivityModel>) activityRepository.findAll();
    }
    
    public ActivityModel saveActivityById(ActivityModel actividad) {
        return activityRepository.save(actividad);
    }
    
    public Optional<ActivityModel> getActivityById(Integer ID_Actividad) {
        if (ID_Actividad == null) {
            // Manejo del error cuando el ID es null
            throw new IllegalArgumentException("El ID_Actividad no puede ser nulo");
        }
        
        return activityRepository.findById(ID_Actividad);
    }
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public ActivityModel updateActivityById(ActivityModel request, Integer ID_Actividad) {
        Optional<ActivityModel> optionalActivity = activityRepository.findById(ID_Actividad);
        if (optionalActivity.isPresent()) {
            ActivityModel activityModel = optionalActivity.get();
            if (request.getIdActividad() != null) {
                activityModel.setIdActividad(request.getIdActividad());
            }
            if (request.getIdEmpleado() != null) {
                activityModel.setIdEmpleado(request.getIdEmpleado());
            }
            if (request.getTipo() != null) {
                activityModel.setTipo(request.getTipo());
            }
            if (request.getDescripcion() != null) {
                activityModel.setDescripcion(request.getDescripcion());
            }
            if (request.getFechaInicio() != null) {
                activityModel.setFechaInicio(request.getFechaInicio());
            }
            if (request.getFechaFinalizacion() != null) {
                activityModel.setFechaFinalizacion(request.getFechaFinalizacion());
            }
            activityRepository.save(activityModel);
            return activityModel;
        } else {
            
            // Manejar el caso en el que la actividad no se encuentra en la base de datos.
            throw new NoSuchElementException("Actividad no encontrada con ID: " + ID_Actividad);
        }
    }
    

    public Boolean deleteActivityById(Integer ID_Actividad) {
        try{
            activityRepository.deleteById(ID_Actividad);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
