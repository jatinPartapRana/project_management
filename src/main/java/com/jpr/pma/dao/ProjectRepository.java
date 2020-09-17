package com.jpr.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpr.pma.dto.ChartData;
import com.jpr.pma.entities.Project;
// here Project is the entity and Long is the primary key Type of that entity.
public interface ProjectRepository extends CrudRepository<Project, Long>{
	//we are overriding the findAll method because by default it returns a Iterable object but we need List<Project>
	@Override 
	public List<Project> findAll();
	@Query(nativeQuery= true, value="select stage as label, count(*) as value from " + 
			"project group by  stage")
	public List<ChartData> getProjectStatus();
}
