package com.shaik.quickinvoice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    private String phone;
    private String email;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    
    
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    private Company company;
    
    public Client() {}
	public Client(Long id, String name, String phone, String email, String city, String state, String zipCode,
			String country) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + "]";
	}
    
}