package com.spr.hib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.hib.dao.PersonDAO;
import com.spr.hib.domain.Person;
//TODO use @repository for dao or use @Service, actually find out which one is better

@Service
public class PersonService  {

	@Autowired
	private PersonDAO personDAO;
	
	public List<Person> findAllPersons() {
		return personDAO.findAllPersons();
		
	}

	public  void persist(Person person) {
		if(person==null)return;
		personDAO.persist(person);
	}

	public Person findPerson(Long id) {
		if (id == null) return null;
		return personDAO.findPerson(id);
	}

}
