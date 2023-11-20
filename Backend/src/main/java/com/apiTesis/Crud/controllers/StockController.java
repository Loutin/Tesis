package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.StockModel;
import com.apiTesis.Crud.services.StockService;

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
@RequestMapping("/Stock")    //Ruta para acceder a las funcionalidades

public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping
	public ArrayList<StockModel> getStockById() {
		return this.stockService.getStockById();
    }

    @PostMapping
    public StockModel saveStockById(@RequestBody StockModel actividad) {
        return this.stockService.saveStockById(actividad);
    }

    @GetMapping(path = "/{ID_Item}")
    public Optional<StockModel> getStockById(@PathVariable Integer ID_Item) {
        return this.stockService.getStockById(ID_Item);
    }
    
    @PutMapping(path = "/{ID_Item}")
    public StockModel updateStockById(@RequestBody StockModel request ,@PathVariable Integer ID_Item){
        return this.stockService.updateStockById(request, ID_Item);   
    }
    
    @DeleteMapping(path = "/{ID_Item}")
    public String deleteStockById(@PathVariable("ID_Item") Integer ID_Item) {
        boolean ok = this.stockService.deleteStockById(ID_Item);

        if(ok){
            return "El medicamento: " + ID_Item + " ha sido eliminado";
        }
        else{
            return "Ups, ha ocurrido un error al eliminar el medicamento: " + ID_Item;
        }
    }
}