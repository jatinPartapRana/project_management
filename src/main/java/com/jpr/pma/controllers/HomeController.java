package com.jpr.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpr.pma.dao.EmolyeeRepository;
import com.jpr.pma.dao.ProjectRepository;
import com.jpr.pma.dto.ChartData;
import com.jpr.pma.dto.EmployeeProject;
import com.jpr.pma.entities.Project;

@Controller
public class HomeController {
	@Autowired
	ProjectRepository proReop;
	@Autowired
	EmolyeeRepository empRepo;
	
	@Value("${version}")
	private String ver;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		model.addAttribute("versionNumber", ver);
		// we are quering the database for projects
		List<Project> projects = proReop.findAll();
		
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proReop.getProjectStatus();
		
		// Convert projectData object to JSON for JS use
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// Here jsonString will have avalues like  [ ["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
		model.addAttribute("projectStatusCnt", jsonString);
		
		//we are quering the database for employees
		List<EmployeeProject> employeesProjectsCount = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectsCount);
		return "main/home";
	}
}
