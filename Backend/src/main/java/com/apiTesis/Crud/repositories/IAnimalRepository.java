package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.AnimalModel;

@Repository
public interface IAnimalRepository extends JpaRepository<AnimalModel, Integer> {
    //Por ahora lo dejo asi.
}