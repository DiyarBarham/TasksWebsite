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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String name;


	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "projects_status", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
	private Set<Status> status = new HashSet<>();
	
	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();
	
	
}
