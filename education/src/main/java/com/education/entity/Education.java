package com.education.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Education {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	private String degree;
    private String institution;
    private String graduationYear;
    

	public Education() {
		super();
	}


	public Education(int id, String degree, String institution, String graduationYear) {
		super();
		this.id = id;
		this.degree = degree;
		this.institution = institution;
		this.graduationYear = graduationYear;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}


	public String getGraduationYear() {
		return graduationYear;
	}


	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	
    
}
