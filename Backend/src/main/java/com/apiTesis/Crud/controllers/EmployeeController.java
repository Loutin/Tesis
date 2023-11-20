package com.apiTesis.Crud.controllers;

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

import com.apiTesis.Crud.models.EmployeeModel;
import com.apiTesis.Crud.services.EmployeeService;


@RestController
@RequestMapping("/Employee")    //Ruta para acceder a las funcionalidades

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ArrayList<EmployeeModel> getEmployeeById() {
		return this.employeeService.getEmployeeById();
    }

    @PostMapping
    public EmployeeModel saveEmployeeById(@RequestBody EmployeeModel empleado) {
        return this.employeeService.saveEmployeeById(empleado);
    }

    @GetMapping(path = "/{ID_Empleado}")
    public Optional<EmployeeModel> getEmployeeById(@PathVariable Integer ID_Empleado) {
        return this.employeeService.getEmployeeById(ID_Empleado);
    }
    
    @PutMapping(path = "/{ID_Empleado}")
    public EmployeeModel updateEmployeeById(@RequestBody EmployeeModel request ,@PathVariable Integer ID_Empleado){
        return this.employeeService.updateEmployeeById(request, ID_Empleado);   
    }
    
    @DeleteMapping(path = "/{ID_Empleado}")
    public String deleteEmployeeById(@PathVariable("ID_Empleado") Integer ID_Empleado) {
        boolean ok = this.employeeService.deleteEmployeeById(ID_Empleado);

        if(ok){
            return "El empleado: " + ID_Empleado + " ha sido eliminado";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar el empleado: " + ID_Empleado;
        }
    }
    
}

