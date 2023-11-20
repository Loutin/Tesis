package com.apiTesis.Crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiTesis.Crud.models.ActivityModel;

@Repository
public interface IActivityRepository extends JpaRepository<ActivityModel, Integer> {
    //Por ahora lo dejo asi.
}