package com.jpr.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpr.pma.dao.EmolyeeRepository;
import com.jpr.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	EmolyeeRepository empRepo;
	@Autowired
	public void setEmpRepo(EmolyeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		empRepo.save(employee);
		return "redirect:/employees/new";
	}
	
}