package com.training.exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.exercise.converter.DepartmentConverter;
import com.training.exercise.converter.EmployeeConverter;
import com.training.exercise.converter.ProjectConverter;
import com.training.exercise.converter.QualificationConverter;
import com.training.exercise.converter.TaskConverter;
import com.training.exercise.dto.DepartmentDto;
import com.training.exercise.dto.EmployeeDto;
import com.training.exercise.dto.ProjectDto;
import com.training.exercise.dto.QualificationDto;
import com.training.exercise.dto.TaskDto;
import com.training.exercise.entities.Employee;
import com.training.exercise.entities.Qualification;
import com.training.exercise.entities.Status;
import com.training.exercise.services.DepartmentServiceImp;
import com.training.exercise.services.EmployeeServiceImp;
import com.training.exercise.services.ProjectServiceImp;
import com.training.exercise.services.QualificationServiceImp;
import com.training.exercise.services.StatusService;
import com.training.exercise.services.TaskServiceImp;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	ProjectServiceImp projectService;
	ProjectConverter projectConverter;
	
	DepartmentServiceImp depService;
	DepartmentConverter depConverter;
	
	EmployeeServiceImp empService;
	EmployeeConverter empConverter;
	
	TaskServiceImp taskService;
	TaskConverter taskConverter;
	
	QualificationServiceImp qualService;
	QualificationConverter qualConverter;
	
	StatusService statusService;
	
	@GetMapping("/")
	@ResponseBody
	String home(Model model) {
		
		return "main";
	}
	
	@GetMapping("/projects")
	@ResponseBody
	String allProjects(Model model) {
		model.addAttribute("projects", projectConverter.entityToDto(projectService.ListAll()));
		return "all projects";
	}
	
	@GetMapping("/departments")
	@ResponseBody
	String allDepartments(Model model) {
		model.addAttribute("departments", depConverter.entityToDto(depService.ListAll()));
		return "all departments";
	}
	
	@GetMapping("/employees")
	@ResponseBody
	String allEmployees(Model model) {
		model.addAttribute("employees", empConverter.entityToDto(empService.ListAll()));
		return "all employees";
	}
	
	@GetMapping("/tasks")
	@ResponseBody
	String allTasks(Model model) {
		model.addAttribute("tasks", taskConverter.entityToDto(taskService.ListAll()));
		return "all tasks";
	}
	@GetMapping("/qualifications")
	@ResponseBody
	String allQualifications(Model model) {
		model.addAttribute("qualifications", qualConverter.entityToDto(qualService.ListAll()));
		return "all qualifications";
	}
	
	@GetMapping("/newstatus")
	@ResponseBody
	String newStatus(Model model) {
		Status status = new Status();
		model.addAttribute("status", status);
		
		return "make new status";
	}
	@PostMapping("/newstatus")
	String newStatusPost(Status status, Model model) {
		
		statusService.save(status);
		
		return "/";
	}
	
	@GetMapping("/newproject")
	@ResponseBody
	String newProject(Model model) {
		ProjectDto project = new ProjectDto();
		model.addAttribute("project", project);
		model.addAttribute("tasks", taskService.ListAll());
		model.addAttribute("employees", empService.ListAll());
		model.addAttribute("status", statusService.ListAll());
		return "make new project";
	}
	@PostMapping("/newproject")
	String newProjectPost(ProjectDto dto, Model model) {
		
		projectService.save(projectConverter.dtoToEntity(dto));
		
		return "/";
	}
	
	@GetMapping("/newdepartment")
	@ResponseBody
	String newDepartment(Model model) {
		DepartmentDto dep = new DepartmentDto();
		model.addAttribute("dep", dep);
		model.addAttribute("employees", empService.ListAllFree());
		return "make new department";
	}
	@PostMapping("/newdepartment")
	String newDepartmentPost(DepartmentDto dto, Model model) {
		
		depService.save(depConverter.dtoToEntity(dto));
		
		return "/";
	}
	
	@GetMapping("/newemployee")
	@ResponseBody
	String newEmployee(Model model) {
		EmployeeDto emp = new EmployeeDto();
		model.addAttribute("emp", emp);
		model.addAttribute("qualifications", qualService.ListAll());
		return "make new employee";
	}
	@PostMapping("/newemployee")
	String newEmployeePost(EmployeeDto dto, Model model) {
		
		empService.save(empConverter.dtoToEntity(dto));
		
		return "/";
	}
	
	@GetMapping("/newtask")
	@ResponseBody
	String newTask(Model model) {
		TaskDto task = new TaskDto();
		model.addAttribute("task", task);
		model.addAttribute("employees", empService.ListAll());
		model.addAttribute("qualifications", qualService.ListAll());
		model.addAttribute("tasks", taskService.ListAll());
		return "make new task";
	}
	@PostMapping("/newtask")
	String newTaskPost(TaskDto dto, Model model) {
		int temp=0;
		for (Employee emp : dto.getEmployees()) {
			for (Qualification q : emp.getQualifications()) {
				temp=0;
				for(Qualification qual : dto.getQualifications()) {
					if(q == qual) temp=1;
				}
				if(temp ==0) return "/error";
			}
			
		}
		
		taskService.save(taskConverter.dtoToEntity(dto));
		
		return "/";
	}
	
	@GetMapping("/error")
	@ResponseBody
	String notFound(Model model) {

		return "Employee does not meet qualifications.";
	}
	
	@GetMapping("/newqualification")
	@ResponseBody
	String newQualification(Model model) {
		QualificationDto qualification = new QualificationDto();
		model.addAttribute("qualification", qualification);
		return "make new qualification";
	}
	@PostMapping("/newqualification")
	String newQualificationPost(QualificationDto dto, Model model) {
		
		qualService.save(qualConverter.dtoToEntity(dto));
		
		return "/";
	}
	
	@GetMapping("/project/{id}")
	@ResponseBody
	String project(@PathVariable("id") Integer id, Model model) {
		ProjectDto project = projectConverter.entityToDto(projectService.FindById(id));
		model.addAttribute("status", statusService.ListAll());
		model.addAttribute("project", project);
		return "One project";
	}
	
	@GetMapping("/department/{id}")
	@ResponseBody
	String department(@PathVariable("id") Integer id, Model model) {
		DepartmentDto department = depConverter.entityToDto(depService.FindById(id));
		model.addAttribute("department", department);
		return "One department";
	}
	
	@GetMapping("/employee/{id}")
	@ResponseBody
	String employee(@PathVariable("id") Integer id, Model model) {
		EmployeeDto employee = empConverter.entityToDto(empService.FindById(id));
		model.addAttribute("employee", employee);
		return "One employee";
	}
	
	@GetMapping("/task/{id}")
	@ResponseBody
	String task(@PathVariable("id") Integer id, Model model) {
		TaskDto task = taskConverter.entityToDto(taskService.FindById(id));
		model.addAttribute("task", task);
		return "One task";
	}
	
	@GetMapping("/qualification/{id}")
	@ResponseBody
	String qualification(@PathVariable("id") Integer id, Model model) {
		QualificationDto qualification = qualConverter.entityToDto(qualService.FindById(id));
		model.addAttribute("qualification", qualification);
		return "One qualification";
	}
	
	
}
