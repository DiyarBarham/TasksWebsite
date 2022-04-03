package com.training.exercise.projectservices;

import java.util.List;
import com.training.exercise.entities.Project;

public interface ProjectService {
	public List<Project> ListAll();
	public Project save(Project project);
}
