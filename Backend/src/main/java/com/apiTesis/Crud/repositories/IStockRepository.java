package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.StockModel;

@Repository
public interface IStockRepository extends JpaRepository<StockModel, Integer> {
    //Por ahora lo dejo asi.
}