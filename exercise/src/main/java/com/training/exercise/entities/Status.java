package com.training.exercise.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 500, nullable = false)
	private String description;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();
	
	@Column(length = 32, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private StatusEnum type;
	
	@ManyToMany(mappedBy = "status")
	private List<Task> tasks;
	
	@ManyToMany(mappedBy = "status")
	private List<Project> projects;
}
