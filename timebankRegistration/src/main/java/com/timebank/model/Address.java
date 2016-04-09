package com.timebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Address {

	@Id
	@Column(name = "idAdress", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAddress;
	
	@Column
	private String street;
	
	@Column
	private String city;
	
	@Column
	private String country;
	
	@Column
	private String continent;
	
	 @ManyToOne
	 private User user;

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}
