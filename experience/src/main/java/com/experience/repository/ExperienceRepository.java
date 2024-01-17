package com.experience.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.experience.entity.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
	List<Experience> findAll();
	Experience findById(int id);
}
