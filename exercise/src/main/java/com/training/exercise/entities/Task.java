package com.training.exercise.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String title;

	@Column(length = 500, nullable = false)
	private String description;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tasks_status", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
	private Set<Status> status = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tasks_employees", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private Set<Employee> employees = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tasks_qualifications", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "qualification_id"))
	private Set<Qualification> qualifications = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
}
