package com.training.exercise.employee;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.training.exercise.converter.DepartmentConverter;
import com.training.exercise.converter.EmployeeConverter;
import com.training.exercise.converter.QualificationConverter;
import com.training.exercise.dto.DepartmentDto;
import com.training.exercise.dto.EmployeeDto;
import com.training.exercise.dto.QualificationDto;
import com.training.exercise.entities.Department;
import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Qualification;
import com.training.exercise.repositories.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeTests {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Test
	public void testCreateProject() {
		EmployeeDto employee = new EmployeeDto();
		DepartmentDto department = new DepartmentDto();
		department.setName("Finance");
		DepartmentConverter depC = new DepartmentConverter();
		Department dep = depC.dtoToEntity(department);
		employee.setFName("Mohammad");
		employee.setLName("Ahmad");
		employee.setDepartment(dep);
		
		QualificationDto qDto = new QualificationDto();
		qDto.setName("JAVA");
		QualificationConverter qCon = new QualificationConverter();
		Qualification q = qCon.dtoToEntity(qDto);
		employee.setQualifications(new HashSet<Qualification>(Arrays.asList(q)));
		
		EmployeeConverter con = new EmployeeConverter();
		Employee emp = repo.save(con.dtoToEntity(employee));
		
		assertThat(emp).isNotNull();
		assertThat(emp.getId()).isGreaterThan(0);
		
	}

}
