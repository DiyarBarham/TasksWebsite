package com.training.exercise.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "qualifications")
@Data
public class Qualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();
	
	@ManyToMany(mappedBy = "qualifications")
	private List<Task> tasks;
	
	@ManyToMany(mappedBy = "qualifications")
	private List<Employee> employees;
}
