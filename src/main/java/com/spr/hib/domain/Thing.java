package com.spr.hib.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import com.spr.hib.domain.hibernate.intercepter.AutoLastUpdate;

@Entity
@Table(name = "Things")

//INTERCEPTOR
public class Thing implements AutoLastUpdate, Serializable {

	private static final long serialVersionUID = 2392846202899889400L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	
	@NotNull
	@Size(min = 3, max = 15)
	private String title;

	private String description;

	// TODO default date now()
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON", updatable = false, nullable = false)
	private Date createdOn = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lAST_MODIFIED_ON")
	private Date lastUpdated;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Date startDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	private Date endDate;
	
	
	@Enumerated(EnumType.STRING)
	private Status status; // TODO should be kind of enum //TODO from springamazon project
	
	
    @NotNull
    @ManyToOne				
    //(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person owner;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tag> tags = new HashSet<Tag>();

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// TODO if we dont specify any annotation it will guess the type of the column and name
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	// TODO can we put annotation at the field level ??
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Date getStartDate() {
		return startDate;
	}
	
	//TODO search for null safe apache commmon string util e.g. for status below
	//TODO this mehtod should be in jsp view helper
	//TODO period counts full day 24 hours we need tomoroow as + 1
	public String getStartDatePositiveDelta(){
		if( startDate != null  && (status == null || !status.getString().equalsIgnoreCase("finished"))){
			Period p = new Period( System.currentTimeMillis(), startDate.getTime(), PeriodType.days());
			System.out.println("startDate" + startDate + "   "+ p.getDays());
			if (p.getDays()>-1)
				return "+" + p.getDays();
			else
				return "" + p.getDays() ;
		}
		return "";	
	}
	
	//TODO search for null safe apache commmon string util e.g. for status below
	//TODO this mehtod should be in jsp view helper
	//TODO period counts full day 24 hours we need tomoroow as + 1
	public String getEndDatePositiveDelta(){
		if( endDate != null  && (status == null || !status.getString().equalsIgnoreCase("finished"))){
			Period p = new Period( System.currentTimeMillis(), endDate.getTime(), PeriodType.days());
			System.out.println("endDate" + endDate + "   "+ p.getDays());
			if (p.getDays()>-1)
				return "+" + p.getDays();
			else
				return "" + p.getDays() ;
		}
		return "";	
	}
	
	public String getTotalPeriod(){
		if( startDate != null && endDate != null  ){
			Period p = new Period( startDate.getTime(), endDate.getTime(), PeriodType.days());
			System.out.println("duration : " + p.getDays());
			if (p.getDays()>-1)
				return "+" + p.getDays();
		}
		return "";	
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Thing [id=" + id + "]";
	}



	/*
	 * @PrePersist this works on for jpa when using entitymanager hibernate should use listeners or some other majik public void preCreate(){ this.createdOn =
	 * new Date(); } //INTERCEPTOR 
	 * 
	 * public void setStatus(String status) { this.status = status; }
	 */
}
