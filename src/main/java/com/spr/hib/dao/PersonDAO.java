package com.spr.hib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spr.hib.domain.Person;
import com.spr.hib.exceptions.EmailAlreadyExistException;
//TODO use @repository for dao or use @Service, actually find out which one is better

@Transactional
@Repository
public class PersonDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//TODO find out if we must have setting apparantly we dont need it
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public List<Person> findAllPersons() {
		Session session = currentSession();
		List<Person> result = session.createQuery("from Person").list(); 
		return result;
	}


	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public  void persist(Person person) {
		if(person==null)return;
		
		Session currentSession = currentSession();
		
		if(person.getEmail()!=null) {//TODO find a better way of doing it
			Query query = currentSession.createQuery("SELECT o FROM Person AS o WHERE LOWER(o.email) LIKE LOWER(:email)" );
			query.setString("email", person.getEmail());
			if( query.list().size() > 0){
				//size should be == 0
				throw new EmailAlreadyExistException(person.getEmail());
			}
			
		}
		
		currentSession.save(person);
	}

	public Person findPerson(Long id) {
		if (id == null) return null;
		Person person = (Person) currentSession().get(Person.class, id);
		return person;
	}

}
