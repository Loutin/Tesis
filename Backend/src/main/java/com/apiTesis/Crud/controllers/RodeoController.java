package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.RodeoModel;
import com.apiTesis.Crud.services.RodeoService;

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
@RequestMapping("/Rodeo")

public class RodeoController {

    @Autowired
    private RodeoService rodeoService;

    @GetMapping
    public ArrayList<RodeoModel> getRodeoById() {
        return this.rodeoService.getRodeoById();
    }

    @PostMapping
    public RodeoModel saveRodeoById(@RequestBody RodeoModel rodeo) {
        return this.rodeoService.saveRodeoById(rodeo);
    }

    @GetMapping(path = "/{ID_Rodeo}")
    public Optional<RodeoModel> getRodeoById(@PathVariable Integer ID_Rodeo) {
        return this.rodeoService.getRodeoById(ID_Rodeo);
    }

    @PutMapping(path = "/{ID_Rodeo}")
    public RodeoModel updateRodeoById(@RequestBody RodeoModel request, @PathVariable Integer ID_Rodeo) {
        return this.rodeoService.updateRodeoById(request, ID_Rodeo);
    }

    @DeleteMapping(path = "/{ID_Rodeo}")
    public String deleteRodeoById(@PathVariable("ID_Rodeo") Integer ID_Rodeo) {
        boolean ok = this.rodeoService.deleteRodeoById(ID_Rodeo);

        if (ok) {
            return "La Rodeo: " + ID_Rodeo + " ha sido eliminado";
        } else {
            return "Ups, ha ocurrido un error al eliminar la Rodeo: " + ID_Rodeo;
        }
    }
}
