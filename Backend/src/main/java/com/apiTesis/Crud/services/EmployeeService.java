package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.EmployeeModel;
import com.apiTesis.Crud.repositories.IEmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    public ArrayList<EmployeeModel> getEmployeeById() {
        return (ArrayList<EmployeeModel>) employeeRepository.findAll();
    }
    
    public EmployeeModel saveEmployeeById(EmployeeModel empleado) {
        return employeeRepository.save(empleado);
    }
    
    public Optional<EmployeeModel> getEmployeeById(Integer ID_Empleado) {
        if (ID_Empleado == null) {
            // Manejo del error cuando ID_Empleado es null
            throw new IllegalArgumentException("El ID_Empleado no puede ser nulo");
        }
        
        return employeeRepository.findById(ID_Empleado);
    }
    
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public EmployeeModel updateEmployeeById(EmployeeModel request, Integer ID_Empleado) {
        Optional<EmployeeModel> optionalEmployee = employeeRepository.findById(ID_Empleado);
        if (optionalEmployee.isPresent()) {
            EmployeeModel employeeModel = optionalEmployee.get();
            if (request.getIdEmpleado() != null) {
                employeeModel.setIdEmpleado(request.getIdEmpleado());
            }
            if (request.getNombre() != null) {
                employeeModel.setNombre(request.getNombre());
            }
            if (request.getCargo() != null) {
                employeeModel.setCargo(request.getCargo());
            }
            if (request.getTelefono() != null) {
                employeeModel.setTelefono(request.getTelefono());
            }
            if (request.getNivel() != null) {
                employeeModel.setNivel(request.getNivel());
            }
            employeeRepository.save(employeeModel);
            return employeeModel;
        } else {
            // Manejar el caso en el que el empleado no se encuentre en la base de datos.
            throw new NoSuchElementException("Empleado no encontrada con ID: " + ID_Empleado);
        }
    }
    

    public Boolean deleteEmployeeById(Integer ID_Empleado) {
        try{
            employeeRepository.deleteById(ID_Empleado);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
