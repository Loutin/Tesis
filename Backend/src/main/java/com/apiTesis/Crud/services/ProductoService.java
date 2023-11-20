package com.apiTesis.Crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTesis.Crud.models.ProductoModel;
import com.apiTesis.Crud.repositories.IProductoRepository;

@Service
public class ProductoService{

    @Autowired
    IProductoRepository productoRepository;

    public ArrayList<ProductoModel> getProductoById() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }
    
    public ProductoModel saveProductoById(ProductoModel producto) {
        return productoRepository.save(producto);
    }
    
    public Optional<ProductoModel> getProductoById(Integer ID_Producto) {
        return productoRepository.findById(ID_Producto);
    }
    
    /*que es lo que tengo que hacer acá?? */

    public ProductoModel updateProductoById(ProductoModel request, Integer ID_Producto) {
        Optional<ProductoModel> optionalProducto = productoRepository.findById(ID_Producto);
        if (optionalProducto.isPresent()) {
            ProductoModel productoModel = optionalProducto.get();
            if (request.getIdProducto() != null) {
                productoModel.setIdProducto(request.getIdProducto());
            }
            if (request.getCategoria() != null) {
                productoModel.setCategoria(request.getCategoria());
            }
            if (request.getNombre() != null) {
                productoModel.setNombre(request.getNombre());
            }
            if (request.getTipo() != null) {
                productoModel.setTipo(request.getTipo());
            }
            if (request.getDescripcion() != null) {
                productoModel.setDescripcion(request.getDescripcion());
            }
            if (request.getMarca() != null) {
                productoModel.setMarca(request.getMarca());
            }
            if (request.getFechaVencimiento() != null) {
                productoModel.setFechaVencimiento(request.getFechaVencimiento());
            }
            productoRepository.save(productoModel);
            return productoModel;
        } else {
            // Manejar el caso en el que el producto no se encuentra en la base de datos.
            throw new NoSuchElementException("Producto no encontrado con ID: " + ID_Producto);
        }
    }
    
    public Boolean deleteProductoById(Integer ID_Producto) {
        try{
            productoRepository.deleteById(ID_Producto);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
