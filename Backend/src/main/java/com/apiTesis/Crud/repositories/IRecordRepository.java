package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.RecordModel;

@Repository
public interface IRecordRepository extends JpaRepository<RecordModel, Integer> {
    //Por ahora lo dejo asi.
}
