package com.training.exercise.services;

import java.util.List;

import com.training.exercise.entities.Project;
import com.training.exercise.entities.Qualification;

public interface QualificationService {
	public List<Qualification> ListAll();
	public Qualification save(Qualification qualification);
	public Qualification FindById(int id);
}
