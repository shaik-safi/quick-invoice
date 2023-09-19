package com.shaik.quickinvoice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//@Entity
public class Sample {
	public Sample(long id, String name, String school) {
		super();
		this.id = id;
		this.name = name;
		this.school = school;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String name;
	private String school;
	@Override
	public String toString() {
		return "Sample [id=" + id + ", name=" + name + ", school=" + school + "]";
	}
	
}
