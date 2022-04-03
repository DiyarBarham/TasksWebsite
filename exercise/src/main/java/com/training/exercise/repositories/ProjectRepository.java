package com.training.exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.exercise.entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
