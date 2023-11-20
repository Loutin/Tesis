package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.ClientModel;

@Repository
public interface IClientRepository extends JpaRepository<ClientModel, Integer> {
    //Por ahora lo dejo asi.
}