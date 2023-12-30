package com.education.controller;

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

import com.education.entity.Education;
import com.education.repository.EducationRepository;

@RestController
@RequestMapping("/educations")
public class EducationController {
	
	@Autowired
	private EducationRepository educationRepository;
	
	@GetMapping
    public List<Education> getAllEducation() {
        return  educationRepository.findAll();
    }
	
	@GetMapping("/{Id}")
	public Education getEducationById(@PathVariable int Id) {
        return  educationRepository.findById(Id);
    }
	
	@GetMapping("/+{year}")
	public List<Education> getEducationByYear(@PathVariable String year) {
        return  educationRepository.findByGraduationYear(year);
    }
	
	@PostMapping
	public Education createEducation(@RequestBody Education education) {
		return educationRepository.save(education);
	}
	
	
	@PutMapping("/{Id}")
	public Education updateEducation(@PathVariable int Id,@RequestBody Education education) {
		education.setId(Id);
		return educationRepository.save(education);
	}
	
	@DeleteMapping("/{Id}")
	public void deleteEducation(@PathVariable int Id) {
		educationRepository.deleteById(Id);
	}
}
