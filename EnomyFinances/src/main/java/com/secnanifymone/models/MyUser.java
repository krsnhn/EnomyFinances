package com.secnanifymone.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;

@Entity
@Table(name = "userdetails")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    
    private Set<Role> roles = new HashSet<>();
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private TotalBalanceUsd totalBalanceUsd;

    public TotalBalanceUsd getBalance() {
        return totalBalanceUsd;
    }

    public void setBalance(TotalBalanceUsd totalBalanceUsd) {
        this.totalBalanceUsd = totalBalanceUsd;
    }

    // Constructors, getters, and setters

    // Default constructor
    public MyUser() {}

    // Constructor with email and password
    public MyUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Constructor with email, password, and roles
    public MyUser(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    // Constructor with all fields
    public MyUser(Long userId, String firstName, String lastName, String email, String password, Set<Role> roles) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    // Getters and setters

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	// Equals method to compare objects based on email and password
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser myUser = (MyUser) o;
        return email.equals(myUser.email) && password.equals(myUser.password);
    }

    // HashCode method to generate a hash code based on email and password
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

	public String getUserName() {
		// TODO Auto-generated method stub
		return email;
	}


}
