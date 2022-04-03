package com.training.exercise.projectservices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.exercise.entities.Project;
import com.training.exercise.repositories.ProjectRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ProjectServiceImp implements ProjectService {

	private ProjectRepository repo;
	
	@Override
	public List<Project> ListAll() {
		return (List<Project>) repo.findAll();
	}

	@Override
	public Project save(Project project) {
		return repo.save(project);
	}

}
