package com.spr.hib.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@javax.persistence.Entity
@Table(name="Tags")
public class Tag implements Serializable {


	private static final long serialVersionUID = -5659222134680963886L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Size(min=3, max=25)
    private String name;

	@Version
    @Column(name = "version")
    private Integer version;
    
	private Integer popularity;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON", updatable = false, nullable = false)
	private Date createdOn = new Date();
    
    @ManyToMany( mappedBy = "tags")
    private Set<Thing> things = new HashSet<Thing>();
    
    public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Set<Thing> getThings() {
		return things;
	}

	public void setThings(Set<Thing> things) {
		this.things = things;
	}

	public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    @Override
   	public String toString() {
   		return "Tag [id=" + id + ", name=" + name + ", version=" + version + ", popularity=" + popularity + ", createdOn=" + createdOn + "]";
   	}
   
}
