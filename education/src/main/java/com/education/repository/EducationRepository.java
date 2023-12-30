package com.education.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
	List<Education> findAll();
	Education findById(int id);
	List<Education> findByGraduationYear(String year);
}
