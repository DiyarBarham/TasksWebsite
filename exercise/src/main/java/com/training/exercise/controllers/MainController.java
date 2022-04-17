package com.training.exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {

	
	@GetMapping("/")
	@ResponseBody
	String home(Model model) {
		
		return "main";
	}
	
	@GetMapping("/newproject")
	@ResponseBody
	String newProject(Model model) {
		
		return "main";
	}
}
