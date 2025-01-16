package com.salesianos.spring.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CochePorMarca {
    
	@Id
	private long idstudent;
	private String fullname;
	private String email;
	private Date matriculationdate;
	private String gender;
	private String spellname;
	private String type;
	private int level;
	private boolean islethal;
	
	//Builder
	public CochePorMarca(long idstudent, String fullname, String email, Date matriculationdate, String gender,
			String spellname, String type, int level, boolean islethal) {
		this.idstudent = idstudent;
		this.fullname = fullname;
		this.email = email;
		this.matriculationdate = matriculationdate;
		this.gender = gender;
		this.spellname = spellname;
		this.type = type;
		this.level = level;
		this.islethal = islethal;
	}

	//Getters
	public long getIdstudent() {
		return idstudent;
	}
	public String getFullname() {
		return fullname;
	}
	public String getEmail() {
		return email;
	}
	public Date getMatriculationdate() {
		return matriculationdate;
	}
	public String getGender() {
		return gender;
	}
	public String getSpellname() {
		return spellname;
	}
	public String getType() {
		return type;
	}
	public int getLevel() {
		return level;
	}
	public boolean isIslethal() {
		return islethal;
	}
	
	//Setters
	public void setIdstudent(long idstudent) {
		this.idstudent = idstudent;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMatriculationdate(Date matriculationdate) {
		this.matriculationdate = matriculationdate;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setSpellname(String spellname) {
		this.spellname = spellname;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setIslethal(boolean islethal) {
		this.islethal = islethal;
	}
}