package com.spr.hib.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Persons")
public class Person implements Serializable {

	private static final long serialVersionUID = 6272214128512426052L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	
	@NotNull
	@Size(min = 3, max = 15)
	private String name;
	
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message="provide valid email please")//validation message
	@Column(name="EMAIL", unique=true, nullable=false)
	private String email;

	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="owner")//TODO diff cascade btw fetch
    private Set<Thing> things = new HashSet<Thing>();
	
	public Set<Thing> getThings() {
		return things;
	}

	public void setThings(Set<Thing> things) {
		this.things = things;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", things=" + things + ", getClass()=" + getClass() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((things == null) ? 0 : things.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (things == null) {
			if (other.things != null)
				return false;
		} else if (!things.equals(other.things))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

//TODO check if it works without getter and setters
//TODO add pattern to name field
//TODO imports like CascadeType.ALL are from jpa where they should be hibernate as i am not using jpa so far ...remove by scanning imports here and in all other classes or migrate to jpa :)