package com.umapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="user")
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    
    @NotNull
    @Size(min=8, max=50)
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;


    @NotNull
    @Column(name = "lastname", nullable = false)
    private String lastname;
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "date_of_birth", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dateOfBirth;
 
    @NotNull
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull
    @Column(name = "mobile", nullable = false)
    private String mobile;
 
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        
        return this.userId == other.userId && this.username.equals(other.username) &&
        		this.firstname.equals(other.firstname) && this.lastname.equals(other.lastname) &&
        		this.dateOfBirth.equals(other.dateOfBirth) && this.email.equals(other.email) && 
        		this.phone.equals(other.phone) && this.mobile.equals(other.mobile);
    }
 
    @Override
    public String toString() {
        return "User {userId: " + userId + ", username: " + username + ", firstname: "+ firstname + 
        		", lastname: " + lastname + ", dateOfBirth: " + dateOfBirth.toString() + 
        		", email: " + email + ", phone: " + phone + ", mobile: " + mobile + "}";
    }
     
}
