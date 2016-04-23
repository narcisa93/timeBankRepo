package com.timebank.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

	@Id
	@Column(name = "id_project")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProject;

	@Column
	private String title;
	@Column
	private String description;

	@Column
	private int offeredTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

    @ManyToMany
    @JoinTable(
        name="ACTIVITY",
        joinColumns=@JoinColumn(name="id_project", referencedColumnName="id_project"),
        inverseJoinColumns=@JoinColumn(name="id_subscriber", referencedColumnName="id_subscriber"))
	private List<Subscriber>subscribers = new ArrayList<Subscriber>();
	
	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOfferedTime() {
		return offeredTime;
	}

	public void setOfferedTimeTime(int offeredTime) {
		this.offeredTime = offeredTime;
	}

}
