package com.training.exercise.project;

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
import com.training.exercise.dto.ProjectDto;
import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Project;
import com.training.exercise.entities.Status;
import com.training.exercise.entities.StatusEnum;
import com.training.exercise.entities.Task;
import com.training.exercise.repositories.EmployeeRepository;
import com.training.exercise.repositories.ProjectRepository;
import com.training.exercise.repositories.TaskRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProjectTests {
	
	@Autowired
	private ProjectRepository repo;
	@Autowired EmployeeRepository empRepo;
	@Autowired TaskRepository taskRepo;
	
	@Test
	public void testCreateProject() {
		ProjectDto project = new ProjectDto();
		
		Status status = new Status();
		status.setType(StatusEnum.New);
		status.setDescription("New project.");
		
		project.setStatus(new HashSet<Status>(Arrays.asList(status)));
		project.setName("testProject");
		Optional<Employee> emp = empRepo.findById(1);
		if(emp.isPresent()) {
			project.setEmployee(emp.get());
		}
		
		ProjectConverter converter = new ProjectConverter();
		Project p = repo.save(converter.dtoToEntity(project));
		assertThat(p).isNotNull();
		assertThat(p.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testAddTaskToProject() {
		Optional<Task> task = taskRepo.findById(1);
		Set<Task> t = new HashSet<Task>();
		
		if(task.isPresent()) {
			t.add(task.get());
		}
		
		Optional<Project> p = repo.findById(1);
		Project project = new Project();
		if(p.isPresent()) {
			project = p.get();
			
		}
		project.setTasks(t);
		assertThat(project.getTasks()).isNotNull();
	}

}
