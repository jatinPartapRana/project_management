package com.jpr.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpr.pma.dao.EmolyeeRepository;
import com.jpr.pma.dao.ProjectRepository;

@SpringBootApplication
public class ProjectManagementApplication {
	
	@Autowired
	EmolyeeRepository empRepo;
	@Autowired
	ProjectRepository projRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
