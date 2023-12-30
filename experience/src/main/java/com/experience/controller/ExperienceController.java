package com.experience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experience.entity.Experience;
import com.experience.repository.ExperienceRepository;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

	@Autowired
	private ExperienceRepository experienceRepository;

	@GetMapping
	public List<Experience> getAllExperience() {
		return experienceRepository.findAll();
	}

	@GetMapping("/{Id}")
	public Experience getExperienceById(@PathVariable int Id) {
		return experienceRepository.findById(Id);
	}

	@GetMapping("/{Id}/skills")
	public List<String> getExperienceSkillById(@PathVariable int Id) {
		return experienceRepository.findById(Id).getSkills();
	}

	@PostMapping
	public Experience createExperience(@RequestBody Experience experience) {
		return experienceRepository.save(experience);
	}

	@PutMapping("/{Id}")
	public Experience updateExperience(@PathVariable int Id, @RequestBody Experience experience) {
		experience.setId(Id);
		return experienceRepository.save(experience);
	}

	@DeleteMapping("/{Id}")
	public void deleteExperience(@PathVariable int Id) {
		experienceRepository.deleteById(Id);
	}
}
