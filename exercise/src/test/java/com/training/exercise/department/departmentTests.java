package com.training.exercise.department;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.training.exercise.converter.DepartmentConverter;
import com.training.exercise.dto.DepartmentDto;
import com.training.exercise.entities.Department;
import com.training.exercise.repositories.DepartmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class departmentTests {

	@Autowired
	private DepartmentRepository repo;
	
	@Test
	public void testCreateProject() {
		DepartmentDto department = new DepartmentDto();
		department.setName("R&D");
		DepartmentConverter depC = new DepartmentConverter();
		Department dep = repo.save(depC.dtoToEntity(department));
		assertThat(dep).isNotNull();
		assertThat(dep.getId()).isGreaterThan(0);
	}
}
