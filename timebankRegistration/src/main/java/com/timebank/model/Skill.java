package com.timebank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table (name = "skills")
public class Skill {
 
	@Id
    @Column (name = "id_skill")
    @GeneratedValue (strategy = GenerationType.AUTO)
	private int idSkill;
	
	 @Column
	private String name;
	 @Column
	private String category;
	 
	 
		@ManyToMany(mappedBy="skills")
	  private List<User> users;
 
	public int getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
