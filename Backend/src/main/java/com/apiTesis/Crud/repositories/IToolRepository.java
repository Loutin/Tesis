package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.ToolModel;

@Repository
public interface IToolRepository extends JpaRepository<ToolModel, Integer> {
    //Por ahora lo dejo asi.
}