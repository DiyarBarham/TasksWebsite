package com.training.exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.exercise.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
