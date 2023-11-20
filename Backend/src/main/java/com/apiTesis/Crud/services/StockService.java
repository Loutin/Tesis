package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.StockModel;
import com.apiTesis.Crud.repositories.IStockRepository;

@Service
public class StockService{

    @Autowired
    IStockRepository stockRepository;

    public ArrayList<StockModel> getStockById() {
        return (ArrayList<StockModel>) stockRepository.findAll();
    }
    
    public StockModel saveStockById(StockModel stock) {
        return stockRepository.save(stock);
    }
    
    public Optional<StockModel> getStockById(Integer ID_Item) {
        if (ID_Item == null) {
            // Manejo del error cuando ID_Item es null
            throw new IllegalArgumentException("El ID_Item no puede ser nulo");
        }
        
        return stockRepository.findById(ID_Item);
    }
    
    
    //Update en con un manejador de errores en el que si el ID no existe en la base de datos se lanza un error
    public StockModel updateStockById(StockModel request, Integer ID_Item) {
        Optional<StockModel> optionalStock = stockRepository.findById(ID_Item);
        if (optionalStock.isPresent()) {
            StockModel stockModel = optionalStock.get();
            if (request.getIdItem() != null) {
                stockModel.setIdItem(request.getIdItem());
            }
            if (request.getIdProducto() != null) {
                stockModel.setIdProducto(request.getIdProducto());
            }
            if (request.getCategoria() != null) {
                stockModel.setCategoria(request.getCategoria());
            }
            if (request.getCantidadDisponible() != null) {
                stockModel.setCantidadDisponible(request.getCantidadDisponible());
            }
            stockRepository.save(stockModel);
            return stockModel;
        } else {
            
            // Manejar el caso en el que el medicamento no se encuentra en la base de datos.
            throw new NoSuchElementException("Medicamento no encontrado con ID: " + ID_Item);
        }
    }
    

    public Boolean deleteStockById(Integer ID_Item) {
        try{
            stockRepository.deleteById(ID_Item);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}


