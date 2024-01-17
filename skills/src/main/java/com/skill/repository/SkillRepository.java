package com.skill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skill.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	List<Skill> findAll();
	Skill findById(int id);
	@Query("SELECT s FROM Skill s WHERE s.name = :name")
	Skill findByName(String name);
}
