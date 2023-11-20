package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.CredentialModel;
import com.apiTesis.Crud.services.CredentialService;

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
@RequestMapping("/Credential")  //Ruta para acceder a las funcionalidades.

public class CredentialController {

	@Autowired
	private CredentialService credentialService;
	
	@GetMapping
	public ArrayList<CredentialModel> getCredentialById() {
		return this.credentialService.getCredentialById();
    }

    @PostMapping
    public CredentialModel saveCredentialById(@RequestBody CredentialModel Usuario) {
        return this.credentialService.saveCredentialById(Usuario);
    }

    @GetMapping(path = "/{ID_Usuario}")
    public Optional<CredentialModel> getCredentialById(@PathVariable Integer ID_Usuario) {
        return this.credentialService.getCredentialById(ID_Usuario);
    }
    
    @PutMapping(path = "/{ID_Usuario}")
    public CredentialModel updateCredentialById(@RequestBody CredentialModel request ,@PathVariable Integer ID_Usuario){
        return this.credentialService.updateCredentialById(request, ID_Usuario);   
    }
    
    @DeleteMapping(path = "/{ID_Usuario}")
    public String deleteCredentialById(@PathVariable("ID_Usuario") Integer ID_Usuario) {
        boolean ok = this.credentialService.deleteCredentialById(ID_Usuario);

        if(ok){
            return "El usuario: " + ID_Usuario + " ha sido eliminado";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar el usuario: " + ID_Usuario;
        }
    }
}

