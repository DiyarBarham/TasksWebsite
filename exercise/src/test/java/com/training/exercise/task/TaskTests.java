package com.training.exercise.task;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.training.exercise.converter.ProjectConverter;
import com.training.exercise.converter.TaskConverter;
import com.training.exercise.dto.TaskDto;
import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Project;
import com.training.exercise.entities.Qualification;
import com.training.exercise.entities.Status;
import com.training.exercise.entities.Task;
import com.training.exercise.repositories.EmployeeRepository;
import com.training.exercise.repositories.ProjectRepository;
import com.training.exercise.repositories.QualificationRepository;
import com.training.exercise.repositories.StatusRepository;
import com.training.exercise.repositories.TaskRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TaskTests {
	
	@Autowired
	private TaskRepository repo;
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired EmployeeRepository empRepo;
	@Autowired StatusRepository statusRepo;
	@Autowired QualificationRepository qRepo;
	
	@Test
	public void testCreateTask() {
		TaskDto task = new TaskDto();
		task.setTitle("New Task");
		task.setDescription("This is a test task.");
		
		Optional<Employee> emp = empRepo.findById(1);
		if(emp.isPresent()) 
			task.setEmployees(new HashSet<Employee>(Arrays.asList(emp.get())));
		
		Optional<Status> status = statusRepo.findById(1);
		if(status.isPresent())
			task.setStatus(new HashSet<Status>(Arrays.asList(status.get())));
		Optional<Project> prj = projectRepo.findById(1);
		if(prj.isPresent())
			task.setProject(prj.get());
		
		Optional<Qualification> qual = qRepo.findById(1);
		if(qual.isPresent())
			task.setQualifications(new HashSet<Qualification>(Arrays.asList(qual.get())));
		
		TaskConverter converter = new TaskConverter();
		Task t = repo.save(converter.dtoToEntity(task));
		assertThat(t).isNotNull();
		assertThat(t.getId()).isGreaterThan(0);
		
	}

}
