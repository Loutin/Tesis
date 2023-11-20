package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.CredentialModel;

@Repository
public interface ICredentialRepository extends JpaRepository<CredentialModel, Integer> {
    //Por ahora lo dejo asi.
}