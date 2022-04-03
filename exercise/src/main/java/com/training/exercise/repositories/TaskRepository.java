package com.training.exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.exercise.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
