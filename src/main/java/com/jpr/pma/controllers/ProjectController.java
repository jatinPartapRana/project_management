package com.jpr.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpr.pma.dao.EmolyeeRepository;
import com.jpr.pma.dao.ProjectRepository;
import com.jpr.pma.entities.Employee;
import com.jpr.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmolyeeRepository empRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		return "projects/project";
	}
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		proRepo.save(project);
		
		return "redirect:/projects";
	}
	
}
