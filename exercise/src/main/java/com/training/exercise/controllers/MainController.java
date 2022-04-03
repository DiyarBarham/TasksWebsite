package com.training.exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {

	
	@GetMapping("/")
	String home(Model model) {
		
		return "main";
	}
}
