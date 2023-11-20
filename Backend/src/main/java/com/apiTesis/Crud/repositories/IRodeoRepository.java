package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.RodeoModel;

@Repository
public interface IRodeoRepository extends JpaRepository<RodeoModel, Integer> {
    //Por ahora lo dejo asi.
}