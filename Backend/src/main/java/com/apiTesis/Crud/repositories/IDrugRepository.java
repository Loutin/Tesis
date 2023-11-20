package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.DrugModel;

@Repository
public interface IDrugRepository extends JpaRepository<DrugModel, Integer> {
    //Por ahora lo dejo asi.
}
