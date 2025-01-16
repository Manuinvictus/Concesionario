package com.salesianos.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marcas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idspell;
	private String spellname;
	private String spelldescription;
	private String type;
	private int level;
	private int damage;
	private boolean islethal;
	
	//Getters
	public long getIdspell() {
		return idspell;
	}
	public String getSpellname() {
		return spellname;
	}
	public String getSpelldescription() {
		return spelldescription;
	}
	public String getType() {
		return type;
	}
	public int getLevel() {
		return level;
	}
	public int getDamage() {
		return damage;
	}
	public boolean getIslethal() {
		return islethal;
	}
	
	//Setters
	public void setIdspell(long idspell) {
		this.idspell = idspell;
	}
	public void setSpellname(String spellname) {
		this.spellname = spellname;
	}
	public void setSpelldescription(String spelldescription) {
		this.spelldescription = spelldescription;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setIslethal(boolean islethal) {
		this.islethal = islethal;
	}
}
