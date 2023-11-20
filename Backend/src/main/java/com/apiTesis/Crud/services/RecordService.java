package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.RecordModel;
import com.apiTesis.Crud.repositories.IRecordRepository;

@Service
public class RecordService{

    @Autowired
    IRecordRepository recordRepository;

    public ArrayList<RecordModel> getRecordById() {
        return (ArrayList<RecordModel>) recordRepository.findAll();
    }
    
    public RecordModel saveRecordById(RecordModel actividad_realizada) {
        return recordRepository.save(actividad_realizada);
    }
    
    public Optional<RecordModel> getRecordById(Integer ID_Actividadrealizada) {
        if (ID_Actividadrealizada == null) {
            // Manejo del error cuando ID_Actividadrealizada es null
            throw new IllegalArgumentException("El ID_Actividadrealizada no puede ser nulo");
        }
        
        return recordRepository.findById(ID_Actividadrealizada);
    }
    
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public RecordModel updateRecordById(RecordModel request, Integer ID_Actividadrealizada) {
        Optional<RecordModel> optionalRecord = recordRepository.findById(ID_Actividadrealizada);
        if (optionalRecord.isPresent()) {
            RecordModel recordModel = optionalRecord.get();
            if (request.getIdActividadRealizada() != null) {
                recordModel.setIdActividadRealizada(request.getIdActividadRealizada());
            }
            if (request.getIdActividad() != null) {
                recordModel.setIdActividad(request.getIdActividad());
            }
            if (request.getIdEmpleado() != null) {
                recordModel.setIdEmpleado(request.getIdEmpleado());
            }
            if (request.getIdRodeo() != null) {
                recordModel.setIdRodeo(request.getIdRodeo());
            }
            if (request.getTipo() != null) {
                recordModel.setTipo(request.getTipo());
            }
            if (request.getFechaFinalizacion() != null) {
                recordModel.setFechaFinalizacion(request.getFechaFinalizacion());
            }
            if (request.getDescripcion() != null) {
                recordModel.setDescripcion(request.getDescripcion());
            }
            if (request.getTiempoRealizacion() != null) {
                recordModel.setTiempoRealizacion(request.getTiempoRealizacion());
            }
            recordRepository.save(recordModel);
            return recordModel;
        } else {
            // Manejar el caso en el que el historial no se encuentre en la base de datos.
            throw new NoSuchElementException("Historial no encontrado con ID: " + ID_Actividadrealizada);
        }
    }
    

    public Boolean deleteRecordById(Integer ID_Actividadrealizada) {
        try{
            recordRepository.deleteById(ID_Actividadrealizada);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
