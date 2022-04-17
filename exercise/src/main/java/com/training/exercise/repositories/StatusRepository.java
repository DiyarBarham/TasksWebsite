package com.training.exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {

}
