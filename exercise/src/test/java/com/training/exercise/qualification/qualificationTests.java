package com.training.exercise.qualification;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.training.exercise.converter.QualificationConverter;
import com.training.exercise.dto.QualificationDto;
import com.training.exercise.entities.Qualification;
import com.training.exercise.repositories.QualificationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class qualificationTests {

	@Autowired
	private  QualificationRepository repo;
	
	@Test
	public void testCreateQualifications() {
		QualificationDto qDto = new QualificationDto();
		qDto.setName("HTML");
		QualificationConverter qCon = new QualificationConverter();
		Qualification q = repo.save(qCon.dtoToEntity(qDto));
		assertThat(q).isNotNull();
		assertThat(q.getId()).isGreaterThan(0);
	}
}
