package com.salesianos.spring.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches")
public class Coches {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idstudent;
	private String fullname;
	private String dni;
	private String email;
	private boolean ismuggle;
	private Date matriculationdate;
	private Date birthdate;
	private String gender;
	private long spellknown;
	
	//Getters
	public long getIdstudent() {
		return idstudent;
	}
	public String getFullname() {
		return fullname;
	}
	public String getDni() {
		return dni;
	}
	public String getEmail() {
		return email;
	}
	public boolean getIsmuggle() {
		return ismuggle;
	}
	public Date getMatriculationdate() {
		return matriculationdate;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public String getGender() {
		return gender;
	}
	
	//Setters
	public long getSpellknown() {
		return spellknown;
	}
	public void setIdstudent(long idstudent) {
		this.idstudent = idstudent;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIsmuggle(boolean ismuggle) {
		this.ismuggle = ismuggle;
	}
	public void setMatriculationdate(Date matriculationdate) {
		this.matriculationdate = matriculationdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setSpellknown(long spellknown) {
		this.spellknown = spellknown;
	}
}