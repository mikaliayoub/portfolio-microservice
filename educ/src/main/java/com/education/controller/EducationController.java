package com.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.education.entity.Education;
import com.education.repository.EducationRepository;

@RestController
@RequestMapping("/educations")
@CrossOrigin(origins = "http://localhost:3000/")
public class EducationController {
	
	@Autowired
	private EducationRepository educationRepository;
	
	@GetMapping
    public List<Education> getAllEducation() {
        return  educationRepository.findAll();
    }
	
	@GetMapping("/{EducId}")
	public Education getEducationById(@PathVariable int EducId) {
        return  educationRepository.findById(EducId);
    }
	
	@GetMapping("/+{year}")
	public List<Education> getEducationByYear(@PathVariable String year) {
        return  educationRepository.findByGraduationYear(year);
    }
	
	@PostMapping
	public Education createEducation(@RequestBody Education education) {
		return educationRepository.save(education);
	}
	
	
	@PutMapping("/{EduId}")
	public Education updateEducation(@PathVariable int EduId,@RequestBody Education education) {
		education.setId(EduId);
		return educationRepository.save(education);
	}
	
	@DeleteMapping("/{EducId}")
	public void deleteEducation(@PathVariable int EducId) {
		educationRepository.deleteById(EducId);
	}
}
