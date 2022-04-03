package com.training.exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.exercise.entities.Qualification;

@Repository
public interface QualificationRepository extends CrudRepository<Qualification, Integer> {

}
