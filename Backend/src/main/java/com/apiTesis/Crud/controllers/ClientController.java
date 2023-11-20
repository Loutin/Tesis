package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.ClientModel;
import com.apiTesis.Crud.services.ClientService;

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
@RequestMapping("/Client") //Ruta para acceder a las funcionalidades

public class ClientController {

	@Autowired
	private ClientService ClientService;
	
	@GetMapping
	public ArrayList<ClientModel> getClientById() {
		return this.ClientService.getClientById();
    }

    @PostMapping
    public ClientModel saveClientById(@RequestBody ClientModel client) {
        return this.ClientService.saveClientById(client);
    }

    @GetMapping(path = "/{ID_Cliente}")
    public Optional<ClientModel> getClientById(@PathVariable Integer ID_Cliente) {
        return this.ClientService.getClientById(ID_Cliente);
    }
    
    @PutMapping(path = "/{ID_Cliente}")
    public ClientModel updateClientById(@RequestBody ClientModel request ,@PathVariable Integer ID_Cliente){
        return this.ClientService.updateClientById(request, ID_Cliente);   
    }
    
    @DeleteMapping(path = "/{ID_Cliente}")
    public String deleteClientById(@PathVariable("ID_Cliente") Integer ID_Cliente) {
        boolean ok = this.ClientService.deleteClientById(ID_Cliente);

        if(ok){
            return "El cliente: " + ID_Cliente + " ha sido eliminado";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar el cliente: " + ID_Cliente;
        }
    }
}