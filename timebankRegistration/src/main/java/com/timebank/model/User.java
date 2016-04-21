package com.timebank.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table (name = "users")
public class User {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "firstName")
    @NotEmpty (message = "First name should not be empty")
    private String firstName;

    @Column (name = "lastName")
    @NotEmpty (message = "Last Name should not be empty")
    private String lastName;

    @Column (name = "email")
    @Email
    @NotEmpty (message = "A valid Email must be provided")
    private String email;

    @Column (name = "password")
    @Size(min = 6, message = "Password must have 6 characters at least")
    private String password;
    
    @Column (name = "gender")
    String gender;
   // @Column (name = "birth_date")
   // Date birthDate;
    @Column (name = "phone_number")
    String phoneNumber;
    
    @Column (name = "profile_picture")
    String profilePicture;
    
    
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private List<UserLoginHistory> history = new ArrayList<UserLoginHistory>();
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "user")
    private List<Project> projects = new ArrayList<Project>();
    
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private List<Address> addresses = new ArrayList<Address>();


    
    @ManyToMany
    @JoinTable(
        name="SKILLS_USERS",
        joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="id_skill", referencedColumnName="id_skill"))
    private List<Skill> skills;
    public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName () {
        return this.firstName + " " + this.lastName;
    }

    public List<UserLoginHistory> getHistory() {
        return history;
    }

    public void setHistory(List<UserLoginHistory> history) {
        this.history = history;
    }

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
*/
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
    
}
