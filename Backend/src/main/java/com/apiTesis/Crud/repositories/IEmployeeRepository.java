package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.EmployeeModel;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
    //Por ahora lo dejo asi como esta.
}