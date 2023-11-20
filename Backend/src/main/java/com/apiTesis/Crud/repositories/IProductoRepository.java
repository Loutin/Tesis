package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.ProductoModel;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoModel, Integer> {
    
}


