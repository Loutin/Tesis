package com.apiTesis.Crud.controllers;

import com.apiTesis.Crud.models.ProductoModel;
import com.apiTesis.Crud.services.ProductoService;

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
@RequestMapping("/Producto")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ArrayList<ProductoModel> getProductoById() {
        return this.productoService.getProductoById();
    }

    @PostMapping
    public ProductoModel saveProductById(@RequestBody ProductoModel producto) {
        return this.productoService.saveProductoById(producto);
    }

    @GetMapping(path = "/{ID_Producto}")
    public Optional<ProductoModel> getProductById(@PathVariable Integer ID_Producto) {
        return this.productoService.getProductoById(ID_Producto);
    }

    @PutMapping(path = "/{ID_Producto}")
    public ProductoModel updateProductById(@RequestBody ProductoModel request, @PathVariable Integer ID_Producto) {
        return this.productoService.updateProductoById(request, ID_Producto);
    }

    @DeleteMapping(path = "/{ID_Producto}")
    public String deleteProductById(@PathVariable("ID_Producto") Integer ID_Producto) {
        boolean ok = this.productoService.deleteProductoById(ID_Producto);

        if (ok) {
            return "El producto: " + ID_Producto + " ha sido eliminado";
        } else {
            return "Ups, ha ocurrido un error al eliminar el producto: " + ID_Producto;
        }
    }
}

